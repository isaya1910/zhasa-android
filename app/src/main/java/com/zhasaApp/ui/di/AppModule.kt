package com.zhasaApp.ui.di

import com.zhasaApp.ui.common.viewmodel.DispatcherProvider
import com.zhasaApp.ui.common.viewmodel.RealDispatcherProvider
import com.zhasaApp.ui.login.viewmodels.LoginMiddleWare
import com.zhasaApp.ui.login.viewmodels.LoginReducer
import com.zhasaApp.ui.login.viewmodels.LoginViewModel
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
}
