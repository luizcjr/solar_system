package com.example.solarsystemclean.util

import androidx.room.TypeConverter
import com.example.solarsystemclean.domain.model.Planets
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverterUtil {

    @TypeConverter
    fun favoritePlanetToString(planets: Planets): String {
        return Gson().toJson(planets)
    }

    @TypeConverter
    fun stringToFavoritePlanet(data: String): Planets {
        val listType = object : TypeToken<Planets>() {}.type
        return Gson().fromJson(data, listType)
    }
}