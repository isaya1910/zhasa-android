package com.zhasaApp.repository

sealed class AuthState {
    data class SignIn(val token: String): AuthState()
    object SignOut: AuthState()
}
