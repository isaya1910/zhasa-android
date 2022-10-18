package com.zhasa_app.repository

interface UserDataSource {
    suspend fun syncUser(token: String): User
}