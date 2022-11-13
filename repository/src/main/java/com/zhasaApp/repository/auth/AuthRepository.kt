package com.zhasaApp.repository.auth

import com.zhasaApp.repository.User
import com.zhasaApp.repository.result.RequestResult
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
    val user: StateFlow<RequestResult<User>>
    suspend fun authenticate(email: String, password: String): RequestResult<User>
}