package com.zhasaApp.data.api

import com.zhasaApp.data.models.LoginRequest
import com.zhasaApp.data.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("account/login/email/")
    suspend fun login(@Body login: LoginRequest): Response<LoginResponse>
}