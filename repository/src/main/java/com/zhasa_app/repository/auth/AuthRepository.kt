package com.zhasa_app.repository.auth

import com.zhasa_app.repository.User
import com.zhasa_app.repository.result.RequestResult

interface AuthRepository {
    suspend fun authenticate(email: String, password: String): RequestResult<User>
}