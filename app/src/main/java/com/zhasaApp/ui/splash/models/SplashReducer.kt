package com.zhasaApp.ui.splash.models

import com.zhasa.mvi.Reducer

class SplashReducer : Reducer<SplashAction, SplashState> {
    override fun reduce(action: SplashAction, state: SplashState): SplashState {
        println(action::class.java)
        return when (action) {
            SplashAction.CheckAuthState -> SplashState.InitialState
            SplashAction.NoAction -> SplashState.InitialState
            SplashAction.SignIn -> SplashState.MainState
            SplashAction.SignOut -> SplashState.LoginState
        }
    }
}
