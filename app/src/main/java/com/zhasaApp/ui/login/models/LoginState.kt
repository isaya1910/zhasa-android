package com.zhasaApp.ui.login.models

import com.zhasa.mvi.State

sealed class LoginState : State {
    object InitialState : LoginState()
    object SuccessState : LoginState()
    data class ErrorState(private val error: String) : LoginState()
    object LoadingState : LoginState()
}
