package com.zhasaApp.data.api

import com.zhasaApp.data.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("account/login/email/")
    suspend fun login(@Body login: LoginRequest): Response<LoginResponse>

    @POST("statistic/daily_data_for_year/")
    suspend fun yearLeadingData(@Body statisticYearRequest: StatisticYearRequest): Response<LeadingYearStatisticResponse>

    @POST("statistic/weekly_data_for_year/")
    suspend fun yearLaggingData(@Body statisticYearRequest: StatisticYearRequest): Response<LaggingYearStatisticResponse>

    @POST("statistic/data_wor_week")
    suspend fun weekLeadingData(@Body statisticWeekRequest: StatisticWeekRequest): Response<LeadingWeekStatisticResponse>
}