package com.example.core.persistence.datasource

import com.example.data.remote.dto.UserDTO

interface UserDataSource {
    suspend fun insertUser(user: UserDTO)
    suspend fun getUser(name: String): UserDTO?
}