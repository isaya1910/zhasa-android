package com.zhasaApp.ui.splash.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.zhasaApp.R
import com.zhasaApp.ui.navigation.RootNavigationModel
import com.zhasaApp.ui.splash.models.SplashState
import com.zhasaApp.ui.theme.Colors
import com.zhasaApp.ui.theme.Size
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SplashView(
    navHostController: NavHostController,
    splashState: StateFlow<SplashState>,
    onEvent: () -> Unit
) {
    LaunchedEffect(Unit) {
        onEvent.invoke()
        splashState.collectLatest {
            when (it) {
                SplashState.InitialState -> {}
                SplashState.LoginState -> {
                    navHostController.navigate(RootNavigationModel.Login.route)
                }
                SplashState.MainState -> {
                    navHostController.navigate(RootNavigationModel.Main.route)
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = Colors.BlackPrimary)
            .fillMaxWidth()
            .padding(start = Size.SPACE_2, end = Size.SPACE_2)
    ) {
        Image(
            modifier = Modifier
                .height(Size.SPACE_8)
                .width(Size.SPACE_8)
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.ic_splash),
            contentDescription = ""
        )
    }
}
