package com.example.solarsystemclean.data.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.solarsystemclean.domain.model.Features
import com.example.solarsystemclean.domain.model.Planets

@Entity
data class PlanetsFavoriteEntity(
    var planet: Planets
) {

    @PrimaryKey(autoGenerate = false)
    var id: Int = 0

    companion object {
        fun fromPlanet(planet: Planets) =
            PlanetsFavoriteEntity(
                planet = planet
            )
    }

    fun toPlanet() = Planets(
        id = planet.id,
        name = planet.name,
        resume = planet.resume,
        introduction = planet.introduction,
        image = planet.image,
        searchTags = planet.searchTags,
        features = planet.features,
        geography = planet.geography,
        favorite = planet.favorite
    )
}