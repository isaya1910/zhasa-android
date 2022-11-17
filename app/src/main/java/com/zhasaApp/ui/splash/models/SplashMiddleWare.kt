package com.zhasaApp.ui.splash.models

import com.zhasa.mvi.MiddleWare
import com.zhasaApp.repository.AuthState
import com.zhasaApp.repository.auth.AuthRepository

class SplashMiddleWare(private val authRepository: AuthRepository) : MiddleWare<SplashAction> {
    override suspend fun effect(action: SplashAction): SplashAction {
        if (action == SplashAction.CheckAuthState) {
            return when (authRepository.authState()) {
                is AuthState.SignIn -> SplashAction.SignIn
                is AuthState.SignOut -> SplashAction.SignOut
            }
        }
        return SplashAction.NoAction
    }
}
