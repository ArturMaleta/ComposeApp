package com.example.composeapp.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.composeapp.R
import com.example.composeapp.extensions.startActivityWithFinish

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.MyApplicationTheme)
        super.onCreate(savedInstanceState)

        openDashboard()
    }

    private fun openDashboard() = startActivityWithFinish(MainActivity.intent(this))
}
