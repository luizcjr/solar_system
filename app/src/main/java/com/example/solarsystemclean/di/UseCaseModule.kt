package com.example.solarsystemclean.di

import com.example.solarsystemclean.domain.usecase.PlanetsUseCase
import com.example.solarsystemclean.domain.usecase.PlanetsUseCaseImpl
import com.example.solarsystemclean.domain.usecase.UserUseCase
import com.example.solarsystemclean.domain.usecase.UserUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    factory<UserUseCase> {
        UserUseCaseImpl(get())
    }

    factory<PlanetsUseCase> {
        PlanetsUseCaseImpl(get())
    }
}