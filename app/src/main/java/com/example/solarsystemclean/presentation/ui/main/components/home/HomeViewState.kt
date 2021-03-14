package com.example.solarsystemclean.presentation.ui.main.components.home

import com.example.solarsystemclean.presentation.common.BaseViewState

class HomeViewState(
    val isLoading: Boolean = false,
    val hasError: HomeError = HomeError.NO_ERROR
) : BaseViewState() {
    companion object {
        enum class HomeError {
            NO_ERROR, UNKNOWN, EMPTY
        }

        fun loadingState() = HomeViewState(isLoading = true, hasError = HomeError.NO_ERROR)
        fun mainSuccess() =
            HomeViewState(isLoading = false, hasError = HomeError.NO_ERROR)

        fun mainEmpty() =
            HomeViewState(isLoading = false, hasError = HomeError.EMPTY)

        fun failedUnknownErrorState() =
            HomeViewState(isLoading = false, hasError = HomeError.UNKNOWN)
    }
}