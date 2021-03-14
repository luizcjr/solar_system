package com.example.solarsystemclean.presentation.ui.main.components.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.solarsystemclean.domain.usecase.PlanetsUseCase
import com.example.solarsystemclean.presentation.common.BaseViewModel
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel
import com.example.solarsystemclean.presentation.ui.model.toUiModel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SearchViewModel : BaseViewModel<SearchViewState>(), KoinComponent {

    private val planetsUseCase: PlanetsUseCase by inject()

    private val _planets = MutableLiveData<List<PlanetUiModel>>()
    val planets = _planets as LiveData<List<PlanetUiModel>>

    fun fetchPlanets() {
        updateViewState(SearchViewState.loadingState())

        viewModelScope.launch {
            val response = planetsUseCase.invoke()
            updateViewState(SearchViewState.mainSuccess())

            _planets.value = response.map {
                it.toUiModel()
            }
        }
    }
}