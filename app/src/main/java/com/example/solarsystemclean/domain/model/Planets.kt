package com.example.solarsystemclean.domain.model

data class Planets (
    val id: String?,
    val name: String?,
    val resume: String?,
    val introduction: String?,
    val image: String?,
    val searchTags: List<String>?,
    val features: Features?,
    val geography: String?,
    val favorite: Boolean?
)