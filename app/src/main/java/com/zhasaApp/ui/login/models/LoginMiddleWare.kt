package com.zhasaApp.ui.login.models

import com.zhasa.mvi.MiddleWare
import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.repository.result.RequestResult

class LoginMiddleWare(private val authRepository: AuthRepository) : MiddleWare<LoginAction> {
    override suspend fun effect(action: LoginAction): LoginAction {
        if (action is LoginAction.Login) {
            return when (authRepository.authenticate(action.email, action.password)) {
                is RequestResult.Error -> LoginAction.Error
                is RequestResult.Success -> LoginAction.Succeed
            }
        }
        return LoginAction.NoAction
    }
}
