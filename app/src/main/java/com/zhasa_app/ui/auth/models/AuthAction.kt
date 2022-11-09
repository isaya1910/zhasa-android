package com.zhasa_app.ui.auth.models

import com.zhasa.mvi.Action

sealed class AuthAction : Action {
    data class Login(val email: String, val password: String) : AuthAction()
    object Succeed : AuthAction()
    object Error: AuthAction()
    object NoAction: AuthAction()
}