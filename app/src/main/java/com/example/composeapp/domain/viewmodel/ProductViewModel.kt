package com.example.composeapp.domain.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.domain.model.ProductModel
import com.example.composeapp.repository.Repository
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: Repository) : ViewModel() {
    val products: MutableState<List<ProductModel>> = mutableStateOf(listOf())

    fun getProducts() {
        viewModelScope.launch {
            val productsFormRepository = repository.getProducts()
            products.value = productsFormRepository
        }
    }
}
