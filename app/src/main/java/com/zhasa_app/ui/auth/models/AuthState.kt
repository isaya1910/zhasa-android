package com.zhasa_app.ui.auth.models

import com.zhasa.mvi.State

sealed class AuthState : State {
    object InitialState : AuthState()
    object SuccessState : AuthState()
    data class ErrorState(private val error: String) : AuthState()
    object LoadingState : AuthState()
}