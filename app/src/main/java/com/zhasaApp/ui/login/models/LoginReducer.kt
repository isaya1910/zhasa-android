package com.zhasaApp.ui.login.models

import com.zhasa.mvi.Reducer

class LoginReducer : Reducer<LoginAction, LoginState> {
    override fun reduce(action: LoginAction, state: LoginState): LoginState =
        when (action) {
            is LoginAction.Error -> LoginState.ErrorState("error")
            is LoginAction.Login -> LoginState.LoadingState
            is LoginAction.NoAction -> LoginState.InitialState
            is LoginAction.Succeed -> LoginState.SuccessState
        }
}
