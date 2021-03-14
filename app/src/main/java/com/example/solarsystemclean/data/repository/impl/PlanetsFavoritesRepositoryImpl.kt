package com.example.solarsystemclean.data.repository.impl

import android.content.Context
import com.example.solarsystemclean.data.persistence.db.AppDataBase
import com.example.solarsystemclean.data.persistence.entity.PlanetsFavoriteEntity
import com.example.solarsystemclean.data.repository.PlanetsFavoritesRepository
import com.example.solarsystemclean.domain.model.Planets

class PlanetsFavoritesRepositoryImpl(context: Context): PlanetsFavoritesRepository {
    private val planetsFavoritesDao = AppDataBase.getInstance(context).planetsFavoritesDao()

    override suspend fun insertFavoritePlanet(planets: Planets) {
        planetsFavoritesDao.insertFavoritePlanet(PlanetsFavoriteEntity.fromPlanet(planets))
    }

    override fun readFavoritesPlanets() = planetsFavoritesDao.readFavoritesPlanets().map { it.toPlanet() }

    override suspend fun deleteFavoriteRecipe(id: Int, planets: Planets) {
        planetsFavoritesDao.deleteFavoriteRecipe(PlanetsFavoriteEntity.fromPlanet(planets))
    }
}