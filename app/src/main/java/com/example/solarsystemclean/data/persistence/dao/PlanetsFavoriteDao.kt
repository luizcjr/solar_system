package com.example.solarsystemclean.data.persistence.dao

import androidx.room.*
import com.example.solarsystemclean.data.persistence.entity.PlanetsFavoriteEntity

@Dao
interface PlanetsFavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoritePlanet(planetsFavoriteEntity: PlanetsFavoriteEntity)

    @Query("SELECT * FROM planetsfavoriteentity ORDER BY id ASC")
    fun readFavoritesPlanets(): List<PlanetsFavoriteEntity>

    @Delete
    suspend fun deleteFavoriteRecipe(planetsFavoriteEntity: PlanetsFavoriteEntity)
}