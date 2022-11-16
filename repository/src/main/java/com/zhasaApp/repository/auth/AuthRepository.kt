package com.zhasaApp.repository.auth

import com.zhasaApp.data.api.Api
import com.zhasaApp.data.models.LoginRequest
import com.zhasaApp.repository.AuthState
import com.zhasaApp.data.local.TokenStorage
import com.zhasaApp.repository.result.RequestResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.lang.Exception

interface AuthRepository {
    val user: SharedFlow<AuthState>
    suspend fun authenticate(email: String, password: String): RequestResult<AuthState.SignIn>
    suspend fun authState(): AuthState
}

internal class TokenBasedAuthRepository(
    private val api: Api,
    private val tokenStorage: TokenStorage
) : AuthRepository {
    private val _user = MutableSharedFlow<AuthState>()
    override val user: SharedFlow<AuthState> = _user.asSharedFlow()

    override suspend fun authenticate(
        email: String,
        password: String
    ): RequestResult<AuthState.SignIn> {
        delay(2000)
        try {
            val response = api.login(LoginRequest(email, password))
            if (response.isSuccessful) {
                tokenStorage.saveToken(token = response.body()!!.token)
                return RequestResult.Success(
                    AuthState.SignIn(
                        response.body()!!.token
                    )
                )
            }
            return RequestResult.Error(response.message())
        } catch (e: Exception) {
            e.printStackTrace()
            return RequestResult.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun authState(): AuthState {
        val token = tokenStorage.provideToken()
        if (token.isEmpty()) {
            return AuthState.SignOut
        }
        return AuthState.SignIn(token)
    }
}
