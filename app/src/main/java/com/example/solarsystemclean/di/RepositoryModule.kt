package com.example.solarsystemclean.di

import com.example.solarsystemclean.data.repository.PlanetsRepository
import com.example.solarsystemclean.data.repository.UserRepository
import com.example.solarsystemclean.data.repository.impl.PlanetsImpl
import com.example.solarsystemclean.data.repository.impl.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> {
        UserRepositoryImpl(get())
    }

    single<PlanetsRepository> {
        PlanetsImpl(get())
    }
}