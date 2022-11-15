package com.zhasaApp.repository.auth

import com.zhasaApp.data.api.Api
import com.zhasaApp.data.models.LoginRequest
import com.zhasaApp.repository.User
import com.zhasaApp.repository.UserState
import com.zhasaApp.repository.result.RequestResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.lang.Exception

interface AuthRepository {
    val user: StateFlow<UserState>
    suspend fun authenticate(email: String, password: String): RequestResult<User>
}

internal class AuthRepositoryImpl(private val api: Api): AuthRepository {
    private val _user = MutableStateFlow<UserState>(UserState.SignOut)
    override val user: StateFlow<UserState> = _user.asStateFlow()

    override suspend fun authenticate(email: String, password: String): RequestResult<User> {
        delay(2000)
        try {
            val response = api.login(LoginRequest(email, password))
            if (response.isSuccessful) {
                return RequestResult.Success(User("","",""))
            }
            return RequestResult.Error(response.message())
        } catch (e: Exception) {
            e.printStackTrace()
            return RequestResult.Error(e.localizedMessage)
        }
    }
}