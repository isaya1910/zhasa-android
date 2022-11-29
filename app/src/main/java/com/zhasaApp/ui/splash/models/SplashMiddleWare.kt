package com.zhasaApp.ui.splash.models

import com.zhasa.mvi.MiddleWare
import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.repository.models.AuthState

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
