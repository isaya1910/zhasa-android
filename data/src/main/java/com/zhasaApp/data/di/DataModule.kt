package com.zhasaApp.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.zhasaApp.data.api.Api
import com.zhasaApp.data.local.PreferencesTokenStorage
import com.zhasaApp.data.local.TokenStorage
import com.zhasaApp.data.serialization.LocalDateAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate

val dataModule = module {
    factory { provideHttpClient() }
    factory { provideRetrofit(get(), "https://zhasa-app.kz") }
    factory { provideApi(get()) }
    single<TokenStorage> {
        PreferencesTokenStorage(get())
    }
}

fun provideHttpClient(): OkHttpClient =
    OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }).build()

fun provideRetrofit(okHttpClient: OkHttpClient, apiUrl: String): Retrofit {
    return Retrofit.Builder().baseUrl(apiUrl).client(okHttpClient)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(LocalDate::class.java, LocalDateAdapter())
                    .create()
            )
        ).build()
}

fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)