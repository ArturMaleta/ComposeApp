package com.example.composeapp.util.di

import com.example.composeapp.domain.viewmodel.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProductViewModel(repository = get()) }
}
