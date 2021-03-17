package com.example.solarsystemclean.domain

import com.example.data.remote.dto.UserDTO

object UserFactory {
    val user = UserDTO(
        id = 1,
        name = "Luiz Carlos",
        age = "30",
        email = "luiz_cjr@hotmail.com"
    )
}