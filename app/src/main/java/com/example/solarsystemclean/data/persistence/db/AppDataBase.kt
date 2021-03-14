package com.example.solarsystemclean.data.persistence.db

import android.content.Context
import androidx.room.*
import com.example.solarsystemclean.data.persistence.dao.PlanetsFavoriteDao
import com.example.solarsystemclean.data.persistence.dao.UserDao
import com.example.solarsystemclean.data.persistence.entity.PlanetsFavoriteEntity
import com.example.solarsystemclean.data.persistence.entity.UserEntity
import com.example.solarsystemclean.util.TypeConverterUtil

@Database(entities = [UserEntity::class, PlanetsFavoriteEntity::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverterUtil::class)
abstract class AppDataBase : RoomDatabase() {
    companion object {

        private const val DATABASE_NAME = "solar.db"

        private var instance: AppDataBase? = null

        private fun create(context: Context): AppDataBase =
            Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context): AppDataBase =
            (instance ?: create(context)).also { instance = it }
    }

    abstract fun userDao() : UserDao
    abstract fun planetsFavoritesDao() : PlanetsFavoriteDao
}