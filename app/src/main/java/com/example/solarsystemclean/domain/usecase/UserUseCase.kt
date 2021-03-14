package com.example.solarsystemclean.domain.usecase

import com.example.data.remote.dto.UserDTO
import com.example.solarsystemclean.data.repository.UserRepository

interface UserUseCase {
    suspend operator fun invoke(user: UserDTO)
    suspend operator fun invoke(name: String) : UserDTO
}

class UserUseCaseImpl(private val userRepository: UserRepository) : UserUseCase {
    override suspend fun invoke(user: UserDTO) {
        userRepository.insertUser(user)
    }

    override suspend fun invoke(name: String) = userRepository.getUser(name)!!
}