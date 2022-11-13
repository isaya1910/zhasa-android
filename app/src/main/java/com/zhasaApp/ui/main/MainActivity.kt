package com.zhasaApp.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zhasaApp.ui.login.views.LoginView
import com.zhasaApp.ui.theme.Colors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val systemUIController = rememberSystemUiController()
            systemUIController.setSystemBarsColor(Color.Transparent)
            MaterialTheme(colors = Colors.darkColors) {
                val isLogin by remember { mutableStateOf(true) }
                if (isLogin) {
                    LoginView()
                }
            }
        }
    }
}
