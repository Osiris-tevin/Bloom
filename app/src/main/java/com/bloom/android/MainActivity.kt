package com.bloom.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.bloom.android.ui.WelcomePage

class MainActivity : ComponentActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //DecorView不再为SystemUI(状态栏和导航栏等)预留Padding
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowCompat.getInsetsController(window, window.decorView)
        //状态栏设为亮色 (状态栏的文字、图标颜色为暗色)
        controller?.isAppearanceLightStatusBars = true

        setContent {
            WelcomePage()
        }
    }
}