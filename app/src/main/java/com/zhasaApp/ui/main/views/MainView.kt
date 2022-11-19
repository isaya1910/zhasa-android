package com.zhasaApp.ui.main.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zhasaApp.ui.navigation.BottomMenuNavigationGraph
import com.zhasaApp.ui.navigation.MainBottomView
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size

@Composable
fun MainView() {
    val systemUIController = rememberSystemUiController()
    systemUIController.setSystemBarsColor(Color.Transparent)
    val navController = rememberNavController()
    Scaffold(
        backgroundColor = Colors.BlackPrimary,
        bottomBar = { MainBottomView(navController = navController) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = Size.SPACE_5)
        ) {
            BottomMenuNavigationGraph(navController = navController)
        }
        it.calculateTopPadding()
    }
}
