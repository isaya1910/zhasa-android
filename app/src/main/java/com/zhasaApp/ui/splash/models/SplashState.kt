package com.zhasaApp.ui.splash.models

import com.zhasa.mvi.State

sealed class SplashState : State {
    object InitialState : SplashState()
    object MainState : SplashState()
    object LoginState : SplashState()
}
