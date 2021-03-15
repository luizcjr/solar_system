package com.example.solarsystemclean.data.persistence.dao

import com.example.solarsystemclean.data.persistence.entity.PlanetsFavoriteEntity
import com.example.solarsystemclean.data.repository.PlanetsFavoritesRepository

class PlanetsFavoritesDaoImpl(private val planetsFavoritesRepository: PlanetsFavoritesRepository) : PlanetsFavoriteDao {
    override suspend fun insertFavoritePlanet(planetsFavoriteEntity: PlanetsFavoriteEntity) {
        planetsFavoritesRepository.insertFavoritePlanet(planetsFavoriteEntity.toPlanet())
    }

    override fun readFavoritesPlanets(): List<PlanetsFavoriteEntity> {
        return planetsFavoritesRepository.readFavoritesPlanets().map { PlanetsFavoriteEntity.fromPlanet(it) }
    }

    override suspend fun deleteFavoriteRecipe(planetsFavoriteEntity: PlanetsFavoriteEntity) {
        planetsFavoritesRepository.deleteFavoriteRecipe(planetsFavoriteEntity.id, planetsFavoriteEntity.toPlanet())
    }
}