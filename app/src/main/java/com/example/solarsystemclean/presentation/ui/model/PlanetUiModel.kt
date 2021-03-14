package com.example.solarsystemclean.presentation.ui.model

import android.os.Parcelable
import com.example.solarsystemclean.domain.model.Features
import com.example.solarsystemclean.domain.model.Planets
import kotlinx.parcelize.Parcelize

@Parcelize
class PlanetUiModel(
    val id: String?,
    val name: String?,
    val resume: String?,
    val introduction: String?,
    val image: String?,
    val searchTags: List<String>?,
    val features: Features?,
    val geography: String?,
    val favorite: Boolean?
) : Parcelable

fun Planets.toUiModel() = PlanetUiModel(
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