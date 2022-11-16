package com.zhasaApp.repository

data class User(
    val id: String,
    val firstName: String,
    val secondName: String
)

sealed class AuthState {
    data class SignIn(val token: String): AuthState()
    object SignOut: AuthState()
}
