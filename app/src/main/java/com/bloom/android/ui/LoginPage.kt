package com.bloom.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bloom.android.ui.theme.*

@Composable
fun LoginPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp)
    ) {
        LoginTitle()
        LoginInputBox()
        HintWithUnderLine()
        LoginButton(navController)
    }
}

@Composable
fun LoginTitle() {
    Text(
        text = "Login in with email",
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 184.dp, bottom = 16.dp),
        style = h1,
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = TextAlign.Center
    )
}

@Composable
fun LoginInputBox() {
    LoginTextField(placeholder = "Email address")
    Spacer(modifier = Modifier.height(8.dp))
    LoginTextField(placeholder = "Password (8+ characters)")
}

@Composable
fun LoginTextField(placeholder: String) {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(small),
        placeholder = {
            Text(
                text = placeholder,
                style = body1,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    )
}

@Composable
fun HintWithUnderLine() {
    Column(
        modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp)
    ) {
        TopText()
        BottomText()
    }
}

@Composable
fun TopText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween // 设置两端对齐
    ) {
        val keywordPre = "By clicking below, you agree to our".split("")
        val keywordPost = "and consent".split("")
        for (word in keywordPre) {
            Text(
                text = word,
                style = body2,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Text(
            text = "Terms of Use",
            style = body2,
            color = MaterialTheme.colorScheme.onBackground,
            textDecoration = TextDecoration.Underline // 设置下画线
        )
        for (word in keywordPost) {
            Text(
                text = word,
                style = body2,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun BottomText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center // 设置居中对齐
    ) {
        val keywordPre = "to our ".split("")
        for (word in keywordPre) {
            Text(
                text = word,
                style = body2,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Text(
            text = "Privacy Policy",
            style = body2,
            color = MaterialTheme.colorScheme.onBackground,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Composable
fun LoginButton(navController: NavController) {
    Button(
        onClick = {
            // 导航到LoginPage可组合项
            navController.navigate("home_page")
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(medium),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
    ) {
        Text(
            text = "Log in",
            style = button,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}
