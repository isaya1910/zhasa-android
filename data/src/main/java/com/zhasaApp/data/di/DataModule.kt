package com.zhasaApp.data.di

import com.zhasaApp.data.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    factory { provideHttpClient() }
    factory { provideRetrofit(get(), "https://zhasa-app.kz") }
    factory { provideApi(get()) }
}

fun provideHttpClient(): OkHttpClient =
    OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }).build()

fun provideRetrofit(okHttpClient: OkHttpClient, apiUrl: String): Retrofit {
    return Retrofit.Builder().baseUrl(apiUrl).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)