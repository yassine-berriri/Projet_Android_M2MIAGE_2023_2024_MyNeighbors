package com.example.tp3

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

interface NavigationListener {
    fun showFragment(fragment: Fragment)
    fun updateTitle(@StringRes title: Int)
}