package com.zhasaApp.di

import com.zhasaApp.ui.common.viewmodel.DispatcherProvider
import com.zhasaApp.ui.common.viewmodel.RealDispatcherProvider
import com.zhasaApp.ui.login.models.LoginMiddleWare
import com.zhasaApp.ui.login.models.LoginReducer
import com.zhasaApp.ui.login.viewmodels.LoginViewModel
import com.zhasaApp.ui.splash.models.SplashMiddleWare
import com.zhasaApp.ui.splash.models.SplashReducer
import com.zhasaApp.ui.splash.viewmodels.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<DispatcherProvider> {
        RealDispatcherProvider()
    }
    factory {
        LoginReducer()
    }
    factory {
        LoginMiddleWare(get())
    }
    viewModel {
        LoginViewModel(get(), get(), get())
    }

    factory {
        SplashReducer()
    }
    factory {
        SplashMiddleWare(get())
    }
    viewModel {
        SplashViewModel(get(), get(), get())
    }
}
