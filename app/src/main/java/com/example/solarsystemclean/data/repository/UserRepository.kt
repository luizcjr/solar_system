package com.example.solarsystemclean.data.repository

import com.example.data.remote.dto.UserDTO

interface UserRepository {
    suspend fun insertUser(user: UserDTO)
    suspend fun getUser(name: String):UserDTO?
}