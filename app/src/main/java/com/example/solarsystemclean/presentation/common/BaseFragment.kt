package com.example.solarsystemclean.presentation.common

import androidx.fragment.app.Fragment

abstract class BaseFragment<T>:Fragment() {

    abstract fun updateViewState(viewState: T)
}