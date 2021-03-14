package com.example.solarsystemclean.domain.usecase

import com.example.solarsystemclean.data.repository.PlanetsRepository
import com.example.solarsystemclean.domain.model.Planets

interface PlanetsUseCase {
    suspend operator fun invoke(): List<Planets>
}

class PlanetsUseCaseImpl(private val planetsRepository: PlanetsRepository) : PlanetsUseCase {
    override suspend fun invoke(): List<Planets> = try {
        planetsRepository.getPlanets()
    } catch (ex: Exception) {
        listOf()
    }
}