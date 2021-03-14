package com.example.solarsystemclean.domain.usecase

import com.example.solarsystemclean.data.repository.PlanetsFavoritesRepository
import com.example.solarsystemclean.domain.model.Planets

interface PlanetsFavoritesUseCase {
    suspend operator fun invoke(planets: Planets)
    operator fun invoke(): List<Planets>
    suspend operator fun invoke(id: Int, planets: Planets)
}

class PlanetsFavoritesUseCaseImpl(private val planetsFavoritesRepository: PlanetsFavoritesRepository) :
    PlanetsFavoritesUseCase {
    override suspend fun invoke(planets: Planets) {
        planetsFavoritesRepository.insertFavoritePlanet(planets)
    }

    override fun invoke() = planetsFavoritesRepository.readFavoritesPlanets()

    override suspend fun invoke(id: Int, planets: Planets) {
        planetsFavoritesRepository.deleteFavoriteRecipe(id, planets)
    }

}