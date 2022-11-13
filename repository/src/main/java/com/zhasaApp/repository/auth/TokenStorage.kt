package com.zhasaApp.repository.auth

interface TokenStorage {
    suspend fun provideToken(): String
    suspend fun saveToken(): String
}