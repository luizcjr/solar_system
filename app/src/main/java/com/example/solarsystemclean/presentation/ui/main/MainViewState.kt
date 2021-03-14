package com.example.solarsystemclean.presentation.ui.main

import com.example.solarsystemclean.presentation.common.BaseViewState

class MainViewState(
    val isLoading: Boolean = false,
    val hasError: MainError = MainError.NO_ERROR
) : BaseViewState() {
    companion object {
        enum class MainError {
            NO_ERROR, UNKNOWN, EMPTY
        }

        fun loadingState() = MainViewState(isLoading = true, hasError = MainError.NO_ERROR)
        fun mainSuccess() =
            MainViewState(isLoading = false, hasError = MainError.NO_ERROR)
        fun mainEmpty() =
            MainViewState(isLoading = false, hasError = MainError.EMPTY)
        fun failedUnknownErrorState() =
            MainViewState(isLoading = false, hasError = MainError.UNKNOWN)
    }
}