package com.example.composeapp.domain.util

import android.content.Context
import com.example.composeapp.domain.model.ProductModel
import com.example.composeapp.service.GsonUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductModelUtil(private val context: Context) {
    fun getProducts(): List<ProductModel> {
        val jsonFileString = GsonUtil.getJsonDataFromAsset(context, "data.json")

        val gson = Gson()
        val listProductType = object : TypeToken<List<ProductModel>>() {}.type

        return gson.fromJson(jsonFileString, listProductType)
    }
}

