package com.example.composeapp.extensions

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.composeapp.R

fun Activity.startActivityWithFinish(intent: Intent) {
    startActivity(intent)
    finish()
}

fun Activity.openFragment(sfm: FragmentManager, fragment: Fragment) {
    val transaction = sfm.beginTransaction()
    transaction.replace(R.id.main_fragment_container, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}
