package com.example.solarsystemclean.data.repository

import com.example.solarsystemclean.domain.model.Planets

interface PlanetsFavoritesRepository {
    suspend fun insertFavoritePlanet(planets: Planets)
    fun readFavoritesPlanets(): List<Planets>
    suspend fun deleteFavoriteRecipe(id: Int, planets: Planets)
}