package com.example.composeapp.presentation.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.composeapp.R
import com.example.composeapp.extensions.openFragment
import com.example.composeapp.presentation.ui.fragment.ProductListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragment(supportFragmentManager, ProductListFragment())
    }

    companion object {
        fun intent(context: Context) = Intent(context, MainActivity::class.java).apply { flags = Intent.FLAG_ACTIVITY_SINGLE_TOP }
    }
}