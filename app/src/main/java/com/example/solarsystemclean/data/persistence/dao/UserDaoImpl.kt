package com.example.solarsystemclean.data.persistence.dao

import com.example.solarsystemclean.data.persistence.entity.UserEntity
import com.example.solarsystemclean.data.repository.UserRepository

class UserDaoImpl(private val userRepository: UserRepository) : UserDao {
    override suspend fun insertUser(userEntity: UserEntity) {
        userRepository.insertUser(userEntity.toUser())
    }

    override suspend fun getUser(username: String) = UserEntity.fromUser(userRepository.getUser(username)!!)
}