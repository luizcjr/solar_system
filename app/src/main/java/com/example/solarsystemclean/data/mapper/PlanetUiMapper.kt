package com.example.solarsystemclean.data.mapper

import com.example.solarsystemclean.domain.model.Planets
import com.example.solarsystemclean.presentation.ui.model.PlanetUiModel

class PlanetUiMapper : AbstractMapper<Planets, PlanetUiModel>() {

    override fun toEntity(dto: Planets) = PlanetUiModel(
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

    override fun toDto(entity: PlanetUiModel) = Planets(
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