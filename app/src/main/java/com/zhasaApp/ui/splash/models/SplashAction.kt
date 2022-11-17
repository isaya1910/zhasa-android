package com.zhasaApp.ui.splash.models

import com.zhasa.mvi.Action

sealed class SplashAction : Action {
    object CheckAuthState : SplashAction()
    object NoAction : SplashAction()
    object SignIn : SplashAction()
    object SignOut : SplashAction()
}
