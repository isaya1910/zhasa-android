package com.zhasaApp.repository

interface UserDataSource {
    suspend fun syncUser(token: String): User
}