package com.example.solarsystemclean.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Features(
    val orbitalPeriod: List<String>?,
    val orbitalSpeed: String?,
    val rotationDuration: String?,
    val radius: String?,
    @SerializedName("Diameter")
    val diameter: String?,
    val sunDistance: String?,
    val temperature: String?,
    val satellites: Satellites?
) : Parcelable