package com.zhasaApp.data.di

import com.google.gson.GsonBuilder
import com.zhasaApp.data.api.Api
import com.zhasaApp.data.api.TokenInterceptor
import com.zhasaApp.data.local.PreferencesTokenStorage
import com.zhasaApp.data.local.TokenStorage
import com.zhasaApp.data.serialization.LocalDateAdapter
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate

val dataModule = module {
    single<TokenStorage> {
        PreferencesTokenStorage(get())
    }
    single<Interceptor> {
        TokenInterceptor(get())
    }
    factory { provideHttpClient(get()) }
    factory { provideRetrofit(get(), "https://zhasa-app.kz") }
    factory { provideApi(get()) }
}

fun provideHttpClient(tokenInterceptor: Interceptor): OkHttpClient =
    OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }).addInterceptor(tokenInterceptor).build()

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