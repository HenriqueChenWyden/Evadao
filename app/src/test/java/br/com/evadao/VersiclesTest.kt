package br.com.evadao.Versiculos

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class VersiclesScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testDisplayVersicle() {
        val versicle = "For God so loved the world..."
        composeTestRule.setContent {
            VersiclesScreen(versicle = versicle)
        }

        composeTestRule.onNodeWithText(versicle).assertExists()
    }

    @Test
    fun testDisplayVersicleById() {
        val versicle = "In the beginning God created the heavens and the earth."
        composeTestRule.setContent {
            VersiclesScreen(versicle = versicle)
        }

        composeTestRule.onNodeWithText(versicle).assertExists()
    }

    @Test
    fun testDisplayAllVersicles() {
        val versicles = listOf("For God so loved the world...", "In the beginning God created the heavens and the earth.")
        composeTestRule.setContent {
            VersiclesScreen(versicles = versicles)
        }

        versicles.forEach { versicle ->
            composeTestRule.onNodeWithText(versicle).assertExists()
        }
    }

    @Test
    fun testClickVersicle() {
        val versicle = "For God so loved the world..."
        var clicked = false
        composeTestRule.setContent {
            VersiclesScreen(versicle = versicle, onClick = { clicked = true })
        }

        composeTestRule.onNodeWithText(versicle).performClick()
        assert(clicked)
    }
}