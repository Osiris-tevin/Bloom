package com.bloom.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
            .background(white)
            .padding(horizontal = 16.dp)
    ) {
        LoginTitle()
        LoginInputBox()
        HintWithUnderLine()
        LoginButton()
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
        color = gray,
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
                color = gray
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
                color = gray
            )
        }
        Text(
            text = "Terms of Use",
            style = body2,
            color = gray,
            textDecoration = TextDecoration.Underline // 设置下画线
        )
        for (word in keywordPost) {
            Text(
                text = word,
                style = body2,
                color = gray
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
                color = gray
            )
        }
        Text(
            text = "Privacy Policy",
            style = body2,
            color = gray,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Composable
fun LoginButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(medium),
        colors = ButtonDefaults.buttonColors(pink900)
    ) {
        Text(
            text = "Log in",
            style = button,
            color = white
        )
    }
}
