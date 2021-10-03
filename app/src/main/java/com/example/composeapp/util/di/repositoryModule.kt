package com.example.composeapp.util.di

import com.example.composeapp.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { Repository(context = get()) }
}
