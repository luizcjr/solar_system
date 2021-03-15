package com.example.solarsystemclean.presentation.ui.main.components.favorites

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.solarsystemclean.domain.model.Planets
import com.example.solarsystemclean.domain.usecase.PlanetsFavoritesUseCase
import com.example.solarsystemclean.presentation.common.BaseViewModel
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel
import com.example.solarsystemclean.presentation.ui.model.toUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class FavoritesViewModel : BaseViewModel<FavoritesViewState>() {

    private val planetsFavoritesUseCase: PlanetsFavoritesUseCase by inject()

    private val _planets = MutableLiveData<List<PlanetUiModel>>()
    val planets = _planets as LiveData<List<PlanetUiModel>>

    fun savePlanetsFavorite(planets: Planets) {
        updateViewState(FavoritesViewState.loadingState())

        val planetToSave = Planets(
            id = planets.id,
            name = planets.name,
            resume = planets.resume,
            introduction = planets.introduction,
            image = planets.image,
            searchTags = planets.searchTags,
            features = planets.features,
            geography = planets.geography,
            favorite = true
        )

        coroutineScope.launch {
            updateViewState(FavoritesViewState.favoritesSuccess())
            planetsFavoritesUseCase.invoke(planetToSave)
        }
    }

    fun getPlanetsFavorite() {
        updateViewState(FavoritesViewState.loadingState())

        coroutineScope.launch {
            try {
                if (planetsFavoritesUseCase.invoke().isNotEmpty()) {
                    updateViewState(FavoritesViewState.favoritesSuccess())

                    _planets.postValue(planetsFavoritesUseCase.invoke().map {
                        it.toUiModel()
                    })

                } else {
                    updateViewState(FavoritesViewState.favoritesEmpty())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteFavoritePlanet(id: Int, planets: Planets) {
        updateViewState(FavoritesViewState.loadingState())

        val planetToDelete = Planets(
            id = planets.id,
            name = planets.name,
            resume = planets.resume,
            introduction = planets.introduction,
            image = planets.image,
            searchTags = planets.searchTags,
            features = planets.features,
            geography = planets.geography,
            favorite = false
        )

        coroutineScope.launch {
            updateViewState(FavoritesViewState.favoritesSuccess())
            planetsFavoritesUseCase.invoke(id, planetToDelete)
        }
    }
}