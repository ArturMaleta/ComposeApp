package com.example.composeapp

import android.app.Application
import com.example.composeapp.util.di.repositoryModule
import com.example.composeapp.util.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TheComposeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeDI()
    }

    private fun initializeDI() {
        startKoin {
            androidContext(this@TheComposeApp)
            modules(modules)
        }
    }

    companion object {
        val modules = listOf(
            viewModelModule,
            repositoryModule
        )
    }
}
