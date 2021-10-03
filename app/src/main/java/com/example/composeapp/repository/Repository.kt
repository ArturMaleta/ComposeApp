package com.example.composeapp.repository

import android.content.Context
import com.example.composeapp.domain.model.ProductModel
import com.example.composeapp.domain.util.ProductModelUtil

class Repository(context: Context) {
    private val util = ProductModelUtil(context)

    fun getProducts(): List<ProductModel> {
        return util.getProducts()
    }
}
