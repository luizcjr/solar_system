package com.example.solarsystemclean.domain

import com.example.solarsystemclean.data.repository.PlanetsRepository
import com.example.solarsystemclean.data.repository.impl.GetPlanetsException
import com.example.solarsystemclean.domain.usecase.PlanetsUseCaseImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetPlanetsTest {

    private val repository = mockk<PlanetsRepository>()

    private val getPlanets = PlanetsUseCaseImpl(repository)

    @Test
    fun `when getPlanets get success`() = runBlocking {
        //GIVEN
        coEvery { repository.getPlanets() } returns PlanetsFactory.planets

        //WHEN
        val result = getPlanets()

        //THEN
        Assert.assertEquals(result.size, PlanetsFactory.planets.size)
    }

    @Test
    fun `when getPlanets get exception`() = runBlocking {
        //GIVEN
        coEvery { repository.getPlanets() } throws GetPlanetsException()

        //WHEN
        val result = getPlanets()

        //THEN
        Assert.assertEquals(result.size, 0)
    }
}