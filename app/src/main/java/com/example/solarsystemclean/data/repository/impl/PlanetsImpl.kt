package com.example.solarsystemclean.data.repository.impl

import com.example.solarsystemclean.data.api.output.Output
import com.example.solarsystemclean.data.api.output.parseResponse
import com.example.solarsystemclean.data.api.service.PlanetsService
import com.example.solarsystemclean.data.model.toPlanet
import com.example.solarsystemclean.data.repository.PlanetsRepository
import com.example.solarsystemclean.domain.model.Planets

class PlanetsImpl(private val planetsService: PlanetsService) : PlanetsRepository {
    override suspend fun getPlanets(): List<Planets> {
        return when (val result = planetsService.getPlanets().parseResponse()) {
            is Output.Success -> {
                val responsePlanetsList = result.value

                responsePlanetsList.map {
                    it.toPlanet()
                }
            }
            is Output.Failure -> throw GetPlanetsException()
        }
    }
}

class GetPlanetsException : Exception()