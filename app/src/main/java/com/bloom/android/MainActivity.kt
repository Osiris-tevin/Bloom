package com.bloom.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bloom.android.ui.HomePage
import com.bloom.android.ui.LoginPage
import com.bloom.android.ui.WelcomePage
import com.bloom.android.ui.theme.BloomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //DecorView不再为SystemUI(状态栏和导航栏等)预留Padding
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowCompat.getInsetsController(window, window.decorView)
        //状态栏设为亮色 (状态栏的文字、图标颜色为暗色)
        controller.isAppearanceLightStatusBars = true

        setContent {
            BloomTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    // 创建NavController
    val navController = rememberNavController()
    // 用NavHost将NavController和导航图相关联, startDestination指定起始的可组合项
    NavHost(navController = navController, startDestination = "welcome_page") {
        // 给WelcomePage可组合项指定路径
        composable("welcome_page") { WelcomePage(navController) }
        // 给LoginPage可组合项指定路径
        composable("login_page") { LoginPage(navController) }
        // 给HomePage可组合项指定路径
        composable("home_page") { HomePage() }
    }
}