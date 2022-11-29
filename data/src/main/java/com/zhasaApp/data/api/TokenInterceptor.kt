package com.zhasaApp.data.api

import com.zhasaApp.data.local.TokenStorage
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(private val tokenStorage: TokenStorage) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return runBlocking {
            val token = tokenStorage.provideToken()
            val request = chain.request().newBuilder()
            if (token.isNotEmpty()) {
                request.header("Authorization", token)
            }
            chain.proceed(request.build())
        }
    }
}