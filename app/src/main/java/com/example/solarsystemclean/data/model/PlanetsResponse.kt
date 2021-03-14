package com.example.solarsystemclean.data.model

import com.example.solarsystemclean.domain.model.Features
import com.example.solarsystemclean.domain.model.Planets

data class PlanetsResponse(
    val id: Int?,
    val name: String?,
    val resume: String?,
    val introduction: String?,
    val image: String?,
    val searchTags: List<String>?,
    val features: Features?,
    val geography: String?,
    val favorite: Boolean?
)

fun PlanetsResponse.toPlanet() = Planets(
    id = id,
    name = name,
    resume = resume,
    introduction = introduction,
    image = image,
    searchTags = searchTags,
    features = features,
    geography = geography,
    favorite = favorite
)