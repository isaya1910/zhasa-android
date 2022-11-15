package com.zhasaApp.repository.di

import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.repository.auth.AuthRepositoryImpl
import org.koin.core.scope.get
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }
}