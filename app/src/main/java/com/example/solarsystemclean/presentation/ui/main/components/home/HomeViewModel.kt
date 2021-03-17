package com.example.solarsystemclean.presentation.ui.main.components.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.solarsystemclean.domain.usecase.PlanetsUseCase
import com.example.solarsystemclean.domain.usecase.UserUseCase
import com.example.solarsystemclean.presentation.common.BaseViewModel
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel
import com.example.solarsystemclean.presentation.ui.model.toUiModel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : BaseViewModel<HomeViewState>(), KoinComponent {

    private val planetsUseCase: PlanetsUseCase by inject()
    private val userUseCase: UserUseCase by inject()

    val name = MutableLiveData<String>().apply {
        value = prefHelper.getLastUserSession()?.name
    }

    private val _planets = MutableLiveData<List<PlanetUiModel>>()
    val planets = _planets as LiveData<List<PlanetUiModel>>

    fun fetchPlanets() {
        updateViewState(HomeViewState.loadingState())

        viewModelScope.launch {
            val response = planetsUseCase.invoke()

            if (response.isNotEmpty()) {
                updateViewState(HomeViewState.mainSuccess())

                _planets.value = response.map { planet ->
                    planet.toUiModel()
                }
            } else {
                updateViewState(HomeViewState.mainEmpty())
            }
        }
    }

    fun getUser() {
        viewModelScope.launch {
            userUseCase.invoke(prefHelper.getLastUserSession()?.name!!)
        }
    }
}