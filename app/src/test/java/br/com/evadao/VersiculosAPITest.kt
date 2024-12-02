package br.com.evadao.Versiculos

import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.*

class VersiclesApiServiceTest {

    @Test
    fun testGetVersicle() {
        val apiService = mock(VersiclesApiService::class.java)
        val expectedVersicle = "For God so loved the world..."
        `when`(apiService.getVersicle()).thenReturn(expectedVersicle)

        val actualVersicle = apiService.getVersicle()
        assertEquals(expectedVersicle, actualVersicle)
    }

    @Test
    fun testGetVersicleById() {
        val apiService = mock(VersiclesApiService::class.java)
        val versicleId = 1
        val expectedVersicle = "In the beginning God created the heavens and the earth."
        `when`(apiService.getVersicleById(versicleId)).thenReturn(expectedVersicle)

        val actualVersicle = apiService.getVersicleById(versicleId)
        assertEquals(expectedVersicle, actualVersicle)
    }

    @Test
    fun testGetAllVersicles() {
        val apiService = mock(VersiclesApiService::class.java)
        val expectedVersicles = listOf("For God so loved the world...", "In the beginning God created the heavens and the earth.")
        `when`(apiService.getAllVersicles()).thenReturn(expectedVersicles)

        val actualVersicles = apiService.getAllVersicles()
        assertEquals(expectedVersicles, actualVersicles)
    }
}