package com.zhasaApp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zhasaApp.ui.login.viewmodels.LoginViewModel
import com.zhasaApp.ui.navigation.RootNavigationGraph
import com.zhasaApp.ui.splash.viewmodels.SplashViewModel
import com.zhasaApp.ui.theme.Colors
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val loginViewModel: LoginViewModel by viewModel()
        loginViewModel.bind()
        val splashViewModel: SplashViewModel by viewModel()
        splashViewModel.bind()
        setContent {
            val systemUIController = rememberSystemUiController()
            systemUIController.setSystemBarsColor(Color.Transparent)
            MaterialTheme(colors = Colors.darkColors) {
                RootNavigationGraph(
                    navController = rememberNavController(),
                    loginViewModel = loginViewModel,
                    splashViewModel = splashViewModel
                )
            }
        }
    }
}
