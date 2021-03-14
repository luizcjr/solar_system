package com.example.solarsystemclean.presentation.ui.main.components.search

import com.example.solarsystemclean.presentation.common.BaseViewState

class SearchViewState(
    val isLoading: Boolean = false,
    val hasError: SearchError = SearchError.NO_ERROR
) : BaseViewState() {
    companion object {
        enum class SearchError {
            NO_ERROR, UNKNOWN, EMPTY
        }

        fun loadingState() = SearchViewState(isLoading = true, hasError = SearchError.NO_ERROR)
        fun mainSuccess() =
            SearchViewState(isLoading = false, hasError = SearchError.NO_ERROR)

        fun mainEmpty() =
            SearchViewState(isLoading = false, hasError = SearchError.EMPTY)

        fun failedUnknownErrorState() =
            SearchViewState(isLoading = false, hasError = SearchError.UNKNOWN)
    }
}