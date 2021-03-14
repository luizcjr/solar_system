package com.example.solarsystemclean.presentation.ui.splash

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.BindingAdapter
import com.example.solarsystemclean.util.helper.SharedPreferencesHelper

class SplashBindingAdapter {
    companion object {

        @BindingAdapter("android:viewVisibility")
        @JvmStatic
        fun viewVisibility(view: View, preferencesHelper: SharedPreferencesHelper?) {
            if (preferencesHelper?.getLastUserSession() != null) {
                when (view) {
                    is TextView -> {
                        view.visibility = View.INVISIBLE
                    }
                    is AppCompatEditText -> {
                        view.visibility = View.INVISIBLE
                    }
                    is AppCompatButton -> {
                        view.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }
}