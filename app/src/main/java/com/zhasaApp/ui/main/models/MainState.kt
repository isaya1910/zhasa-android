package com.zhasaApp.ui.main.models

import com.zhasa.mvi.State

sealed class MainState : State {
    object Splash : MainState()
    object SignIn : MainState()
    object SignOut : MainState()
}
