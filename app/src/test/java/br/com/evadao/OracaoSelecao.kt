package br.com.evadao.Oracao

import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.*

class OracaoSelectionScreenTest {

    @Test
    fun testSelectOracao() {
        val oracaoService = mock(OracaoService::class.java)
        val expectedOracao = "Lord, hear our prayer."
        `when`(oracaoService.selectOracao()).thenReturn(expectedOracao)

        val actualOracao = oracaoService.selectOracao()
        assertEquals(expectedOracao, actualOracao)
    }

    @Test
    fun testGetOracaoById() {
        val oracaoService = mock(OracaoService::class.java)
        val oracaoId = 1
        val expectedOracao = "Our Father, who art in heaven..."
        `when`(oracaoService.getOracaoById(oracaoId)).thenReturn(expectedOracao)

        val actualOracao = oracaoService.getOracaoById(oracaoId)
        assertEquals(expectedOracao, actualOracao)
    }

    @Test
    fun testGetAllOracoes() {
        val oracaoService = mock(OracaoService::class.java)
        val expectedOracoes = listOf("Lord, hear our prayer.", "Our Father, who art in heaven...")
        `when`(oracaoService.getAllOracoes()).thenReturn(expectedOracoes)

        val actualOracoes = oracaoService.getAllOracoes()
        assertEquals(expectedOracoes, actualOracoes)
    }
}