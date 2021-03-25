package com.example.solarsystemclean.presentation.ui.model

import android.os.Parcelable
import com.example.solarsystemclean.domain.model.Features
import kotlinx.parcelize.Parcelize

@Parcelize
class PlanetUiModel(
    val id: Int?,
    val name: String?,
    val resume: String?,
    val introduction: String?,
    val image: String?,
    val searchTags: List<String>?,
    val features: Features?,
    val geography: String?,
    val favorite: Boolean?
) : Parcelable