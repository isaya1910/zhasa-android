package com.zhasaApp.di

import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.ui.common.viewmodel.DispatcherProvider
import com.zhasaApp.ui.login.models.LoginMiddleWare
import com.zhasaApp.ui.login.models.LoginReducer
import com.zhasaApp.ui.login.viewmodels.LoginViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.koin.core.context.startKoin
import org.koin.dsl.module

val testModule = module {
    single<AuthRepository> {
        TestAuthRepository()
    }
    single {
        LoginMiddleWare(get())
    }
    single {
        LoginReducer()
    }
    single<DispatcherProvider> {
        object : DispatcherProvider {
            override val io: CoroutineDispatcher = UnconfinedTestDispatcher()
            override val main: CoroutineDispatcher = UnconfinedTestDispatcher()
        }
    }
    single {
        LoginViewModel(get(), get(), get())
    }
}

fun startTestKoin() = startKoin {
    modules(testModule)
}
