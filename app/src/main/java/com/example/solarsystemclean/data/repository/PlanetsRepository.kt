package com.example.solarsystemclean.data.repository

import com.example.solarsystemclean.domain.model.Planets

interface PlanetsRepository {
    suspend fun getPlanets() : List<Planets>
}