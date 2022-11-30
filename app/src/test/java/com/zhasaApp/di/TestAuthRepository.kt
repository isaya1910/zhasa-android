package com.zhasaApp.di

import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.repository.models.AuthState
import com.zhasaApp.repository.result.RequestResult
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class TestAuthRepository : AuthRepository {
    override val user: SharedFlow<AuthState> = MutableSharedFlow()

    override suspend fun authenticate(
        email: String,
        password: String
    ): RequestResult<AuthState.SignIn> {
        if (email == "test" && password == "test") {
            return RequestResult.Success(AuthState.SignIn(""))
        }

        return RequestResult.Error("error")
    }

    override suspend fun authState(): AuthState {
        return AuthState.SignIn("testToken")
    }
}
