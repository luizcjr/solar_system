package com.example.solarsystemclean.presentation.ui.main.components.favorites

import com.example.solarsystemclean.presentation.common.BaseViewState
import com.example.solarsystemclean.presentation.ui.main.MainViewState

class FavoritesViewState(
    val isLoading: Boolean = false,
    val hasError: FavoritesError = FavoritesError.NO_ERROR
) : BaseViewState() {
    companion object {
        enum class FavoritesError {
            NO_ERROR, UNKNOWN, EMPTY
        }

        fun loadingState() =
            FavoritesViewState(isLoading = true, hasError = FavoritesError.NO_ERROR)

        fun favoritesSuccess() =
            FavoritesViewState(isLoading = false, hasError = FavoritesError.NO_ERROR)

        fun favoritesEmpty() =
            FavoritesViewState(isLoading = false, hasError = FavoritesError.EMPTY)

        fun failedUnknownErrorState() =
            FavoritesViewState(isLoading = false, hasError = FavoritesError.UNKNOWN)
    }
}