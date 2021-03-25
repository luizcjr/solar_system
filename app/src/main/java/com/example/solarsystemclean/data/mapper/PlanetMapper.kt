package com.example.solarsystemclean.data.mapper

import com.example.solarsystemclean.data.model.PlanetsResponse
import com.example.solarsystemclean.domain.model.Planets

class PlanetMapper : AbstractMapper<PlanetsResponse, Planets>() {

    override fun toEntity(dto: PlanetsResponse) = Planets(
        id = dto.id,
        name = dto.name,
        resume = dto.resume,
        introduction = dto.introduction,
        image = dto.image,
        searchTags = dto.searchTags,
        features = dto.features,
        geography = dto.geography,
        favorite = dto.favorite
    )

    override fun toDto(entity: Planets) = PlanetsResponse(
        id = entity.id,
        name = entity.name,
        resume = entity.resume,
        introduction = entity.introduction,
        image = entity.image,
        searchTags = entity.searchTags,
        features = entity.features,
        geography = entity.geography,
        favorite = entity.favorite
    )
}