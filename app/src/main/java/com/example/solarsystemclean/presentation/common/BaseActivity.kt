package com.example.solarsystemclean.presentation.common

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T> : AppCompatActivity() {

    abstract fun updateViewState(viewState: T)
}