package com.example.solarsystemclean.di

import com.example.solarsystemclean.data.api.service.PlanetsService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    single<PlanetsService> {
        val retrofit: Retrofit = get()
        retrofit.create(PlanetsService::class.java)
    }
}