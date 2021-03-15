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

        @Volatile
        private var INSTANCE: AppDataBase? = null

        private fun create(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        fun getInstance(context: Context): AppDataBase =
            (INSTANCE ?: create(context)).also { INSTANCE = it }
    }

    abstract fun userDao() : UserDao
    abstract fun planetsFavoritesDao() : PlanetsFavoriteDao
}