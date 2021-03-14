package com.example.solarsystemclean.di

import com.example.solarsystemclean.domain.usecase.*
import org.koin.dsl.module

val useCaseModule = module {

    factory<UserUseCase> {
        UserUseCaseImpl(get())
    }

    factory<PlanetsUseCase> {
        PlanetsUseCaseImpl(get())
    }

    factory<PlanetsFavoritesUseCase> {
        PlanetsFavoritesUseCaseImpl(get())
    }
}