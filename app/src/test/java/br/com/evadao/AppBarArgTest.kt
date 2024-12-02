package br.com.evadao

import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.*

class AppBarTest {

    @Test
    fun testAppBarTitle() {
        val appBar = mock(AppBar::class.java)
        val expectedTitle = "Home"
        `when`(appBar.getTitle()).thenReturn(expectedTitle)

        val actualTitle = appBar.getTitle()
        assertEquals(expectedTitle, actualTitle)
    }

    @Test
    fun testAppBarVisibility() {
        val appBar = mock(AppBar::class.java)
        `when`(appBar.isVisible()).thenReturn(true)

        val isVisible = appBar.isVisible()
        assertTrue(isVisible)
    }

    @Test
    fun testAppBarActions() {
        val appBar = mock(AppBar::class.java)
        val expectedActions = listOf("Search", "Settings")
        `when`(appBar.getActions()).thenReturn(expectedActions)

        val actualActions = appBar.getActions()
        assertEquals(expectedActions, actualActions)
    }
}