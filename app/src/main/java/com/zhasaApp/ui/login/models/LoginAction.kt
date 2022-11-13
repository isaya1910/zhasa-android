package com.zhasaApp.ui.login.models

import com.zhasa.mvi.Action

sealed class LoginAction : Action {
    data class Login(val email: String, val password: String) : LoginAction()
    object Succeed : LoginAction()
    object Error : LoginAction()
    object NoAction : LoginAction()
}
