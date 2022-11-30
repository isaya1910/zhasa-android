package com.zhasaApp.ui

import android.app.Application
import com.zhasaApp.data.di.dataModule
import com.zhasaApp.di.appModule
import com.zhasaApp.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(repositoryModule, dataModule, appModule))
        }
    }
}
