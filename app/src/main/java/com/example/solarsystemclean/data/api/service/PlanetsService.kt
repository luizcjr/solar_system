package com.example.solarsystemclean.data.api.service

import com.example.data.remote.response.BaseResponse
import com.example.solarsystemclean.data.api.constants.Constants
import com.example.solarsystemclean.data.model.PlanetsResponse
import retrofit2.Response
import retrofit2.http.GET

interface PlanetsService {
    @GET(Constants.PLANETS)
    suspend fun getPlanets() : Response<List<PlanetsResponse>>
}