package com.example.solarsystemclean.data.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.remote.dto.UserDTO

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var age: String?,
    var email: String?,
) {


    companion object {
        fun fromUser(user: UserDTO) =
            UserEntity(user.id, user.name, user.age, user.email)
    }

    fun toUser() = UserDTO(id, name, age, email)
}