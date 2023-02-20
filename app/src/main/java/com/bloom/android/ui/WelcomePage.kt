package com.bloom.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bloom.android.R
import com.bloom.android.ui.theme.*

@Preview
@Composable
fun WelcomePage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(pink100) // Color.kt配置的颜色
    ) {
        Image(
            painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.ic_light_welcome_bg)),
            contentDescription = "welcome_bg",
            modifier = Modifier.fillMaxSize()
        )
        WelcomeContent()
    }
}

@Composable
fun WelcomeContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(72.dp))
        LeafImage()
        Spacer(modifier = Modifier.height(48.dp))
        WelcomeTitle()
        Spacer(modifier = Modifier.height(40.dp))
        WelcomeButtons()
    }
}

@Composable
fun LeafImage() {
    Image(
        painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.ic_light_welcome_illos)),
        contentDescription = "welcome_illos",
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 88.dp)
    )
}

@Composable
fun WelcomeTitle() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.ic_light_logo)),
            contentDescription = "welcome_logo",
            modifier = Modifier
                .wrapContentWidth()
                .height(32.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = "Beautiful home garden solutions",
                textAlign = TextAlign.Center,
                style = subtitle1, // Type.kt内配置的字体
                color = Color.Gray // Color.kt内配置的颜色
            )
        }
    }
}

@Composable
fun WelcomeButtons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { },
            modifier = Modifier
                .height(48.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .clip(medium),  // Shape.kt配置的形状
            colors = ButtonDefaults.buttonColors(pink900)
        ) {
            Text(
                text = "Create account",
                style = button, // Type.kt配置的字体
                color = white   // Color.kt配置的颜色
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        TextButton(onClick = { }) {
            Text(
                text = "Log in",
                style = button,  // Type.kt配置的字体
                color = pink900  // Color.kt配置的颜色
            )
        }
    }
}




