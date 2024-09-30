package br.com.evadao

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

@Composable
fun VerseScreen() {
    val verseText = remember { mutableStateOf("Carregando...") }
    var refreshTrigger by remember { mutableStateOf(0) } // Trigger para o refresh

    // Lista de referências de versículos para escolher aleatoriamente
    val verses = listOf(
        "john 3:16",
        "psalm 23:1",
        "genesis 1:1",
        "romans 8:28",
        "matthew 5:9"
    )

    LaunchedEffect(refreshTrigger) {
        val randomVerse = verses[Random.nextInt(verses.size)] // Escolher um versículo aleatório
        val call = VersiclesApiService.ApiClient.retrofit.getRandomVerse(randomVerse)

        call.enqueue(object : Callback<VersiclesApiService.VerseResponse> {
            override fun onResponse(call: Call<VersiclesApiService.VerseResponse>, response: Response<VersiclesApiService.VerseResponse>) {
                if (response.isSuccessful) {
                    val verse = response.body()
                    verseText.value = "${verse?.reference} - ${verse?.text}"
                }
            }

            override fun onFailure(call: Call<VersiclesApiService.VerseResponse>, t: Throwable) {
                verseText.value = "Erro ao carregar versículo."
            }
        })
    }

    // Exibir o versículo na tela com botão de refresh
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = verseText.value, style = MaterialTheme.typography.titleLarge)

        // Botão para carregar um novo versículo
        Button(onClick = { refreshTrigger++ }) {
            Text("Carregar outro versículo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewVerseScreen() {
    VerseScreen()
}
