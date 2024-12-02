package br.com.evadao.Home

import org.junit.Test
import org.junit.Assert.*

class HomeScreenTest {

    @Test
    fun testHomeScreenTitle() {
        val homeScreen = HomeScreen()
        val expectedTitle = "Home"
        assertEquals(expectedTitle, homeScreen.getTitle())
    }

    @Test
    fun testHomeScreenItems() {
        val homeScreen = HomeScreen()
        val expectedItems = listOf("Item1", "Item2", "Item3")
        assertEquals(expectedItems, homeScreen.getItems())
    }

    @Test
    fun testHomeScreenIsVisible() {
        val homeScreen = HomeScreen()
        assertTrue(homeScreen.isVisible())
    }
}