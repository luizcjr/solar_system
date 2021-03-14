package com.example.solarsystemclean.data.repository.impl

import android.content.Context
import com.example.data.remote.dto.UserDTO
import com.example.solarsystemclean.data.persistence.db.AppDataBase
import com.example.solarsystemclean.data.persistence.entity.UserEntity
import com.example.solarsystemclean.data.repository.UserRepository

class UserRepositoryImpl(private val context: Context) : UserRepository {
    val userDao = AppDataBase.getInstance(context).userDao()

    override suspend fun insertUser(user: UserDTO) {
        userDao.insertUser(UserEntity.fromUser(user))
    }

    override suspend fun getUser(name: String) = userDao.getUser(name).toUser()
}