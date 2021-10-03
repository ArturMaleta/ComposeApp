package com.example.composeapp.service

import android.content.Context
import java.io.IOException

class GsonUtil {
    companion object {
        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }

            return jsonString
        }
    }
}

