package com.example.solarsystemclean.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Satellites(
    val number: Int?,
    val names: List<String>?,
) : Parcelable