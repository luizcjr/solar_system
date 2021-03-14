package com.example.solarsystemclean.presentation.ui.splash

import com.example.solarsystemclean.presentation.common.BaseViewState

class SplashViewState(
    val isLoading: Boolean = false,
    val hasError: SplashError = SplashError.NO_ERROR
) : BaseViewState() {
    companion object {
        enum class SplashError {
            NO_ERROR, UNKNOWN
        }

        fun loadingState() = SplashViewState(isLoading = true, hasError = SplashError.NO_ERROR)
        fun splashSuccess() =
            SplashViewState(isLoading = false, hasError = SplashError.NO_ERROR)

        fun failedUnknownErrorState() =
            SplashViewState(isLoading = false, hasError = SplashError.UNKNOWN)
    }
}