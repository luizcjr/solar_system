package com.example.solarsystemclean.domain

import com.example.solarsystemclean.data.repository.UserRepository
import com.example.solarsystemclean.domain.usecase.UserUseCaseImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class UserTest {

    private val repository = mockk<UserRepository>()

    private val userUseCase = UserUseCaseImpl(repository)

    @Test
    fun `when get user data success`() = runBlocking {
        //GIVEN
        coEvery { repository.getUser(UserFactory.user.name) } returns UserFactory.user

        //WHEN
        val result = userUseCase.invoke(UserFactory.user.name)

        //THEN
        Assert.assertEquals(result, UserFactory.user)
    }
}