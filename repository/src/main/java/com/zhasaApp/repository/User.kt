package com.zhasaApp.repository

data class User(
    val id: String,
    val firstName: String,
    val secondName: String
)

sealed class UserState {
    data class SignIn(val user: User): UserState()
    object SignOut: UserState()
}
