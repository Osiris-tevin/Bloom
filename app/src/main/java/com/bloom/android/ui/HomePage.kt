@file:OptIn(ExperimentalMaterial3Api::class)

package com.bloom.android.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bloom.android.R
import com.bloom.android.logic.ImageItem
import com.bloom.android.logic.bloomBannerList
import com.bloom.android.logic.bloomInfoList
import com.bloom.android.logic.navList
import com.bloom.android.ui.theme.*

@Composable
fun HomePage() {
    Scaffold(
        bottomBar = {
            BottomBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp) // 设置边距
        ) {
            SearchBar()
            BloomRowBanner()
            BloomInfoList()
        }
    }
}

@Composable
fun SearchBar() {
    Spacer(modifier = Modifier.height(40.dp))
    Box {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(4.dp))
                .border(BorderStroke(1.dp, if (isSystemInDarkTheme()) white850 else Color.Black)), // 添加圆角边框
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Filled.Search),
                    contentDescription = "search",
                    modifier = Modifier.size(18.dp)
                )
            },
            placeholder = {
                Text(
                    text = "Search",
                    style = body1,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = MaterialTheme.colorScheme.background,
                unfocusedBorderColor = white, // 未选中时的下边框颜色
                focusedBorderColor = white    // 选中时下边框颜色
            )
        )
    }
}

@Composable
fun BloomRowBanner() {
    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Browse themes",
                style = h1,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 32.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            modifier = Modifier.height(136.dp)
        ) {
            items(bloomBannerList.size) {
                if (it != 0) {
                    // 每个子元素间水平间距为8dp
                    Spacer(modifier = Modifier.width(8.dp))
                }
                PlantCard(bloomBannerList[it]) // 使用子元素模板组件
            }
        }
    }
}

@Composable
fun PlantCard(plant: ImageItem) {
    Card(
        modifier = Modifier
            .size(136.dp)
            .clip(RoundedCornerShape(4.dp)),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = plant.resId),
                contentScale = ContentScale.Crop,
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(if (isSystemInDarkTheme()) gray150 else white100)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = plant.name,
                    style = h2,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                )
            }
        }
    }
}

@Composable
fun BloomInfoList() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Design your home garden",
                style = h1,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.paddingFromBaseline(top = 40.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_filter_list),
                contentDescription = "filter",
                modifier = Modifier
                    .padding(top = 24.dp)
                    .size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(bottom = 56.dp)
        ) {
            items(bloomInfoList.size) {
                if (it != 0) {
                    Spacer(modifier = Modifier.height(8.dp))
                    DesignCard(bloomInfoList[it])
                }
            }
        }
    }
}

@Composable
fun DesignCard(plant: ImageItem) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = plant.resId),
            contentScale = ContentScale.Crop,
            contentDescription = "image",
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = plant.name,
                        style = h2,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )
                    Text(
                        text = "This is a description",
                        style = body1,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                    )
                }
                Checkbox(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .size(24.dp),
                    checked = false,
                    onCheckedChange = { },
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = white
                    )
                )
            }
            // 每个子元素底部都有下画线
            Divider(color = MaterialTheme.colorScheme.onBackground, modifier = Modifier.padding(top = 16.dp), thickness = 0.5.dp)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun BottomBar() {
    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        backgroundColor = MaterialTheme.colorScheme.primary
    ) {
        navList.forEach {
            BottomNavigationItem(
                selected = ("Home" == it.name),
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        painter = painterResource(id = it.resId),
                        contentDescription = null,
                        modifier = Modifier.height(24.dp)
                    )
                },
                label = {
                    Text(
                        text = it.name,
                        style = caption,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            )
        }
    }
}