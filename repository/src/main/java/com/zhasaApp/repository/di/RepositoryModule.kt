package com.zhasaApp.repository.di

import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.repository.auth.TokenBasedAuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> {
        TokenBasedAuthRepository(get(), get())
    }
}