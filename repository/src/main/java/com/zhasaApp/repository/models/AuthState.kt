package com.zhasaApp.repository.models

sealed class AuthState {
    data class SignIn(val token: String): AuthState()
    object SignOut: AuthState()
}
