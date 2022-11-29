package com.zhasaApp.repository.di

import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.repository.auth.TokenBasedAuthRepository
import com.zhasaApp.repository.statistic.RemoteStatisticRepository
import com.zhasaApp.repository.statistic.StatisticRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> {
        TokenBasedAuthRepository(get(), get())
    }
    single <StatisticRepository> {
        RemoteStatisticRepository(get())
    }
}