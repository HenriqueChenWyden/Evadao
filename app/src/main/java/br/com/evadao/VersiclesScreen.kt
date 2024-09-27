package br.com.evadao

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun VerseScreen() {
    val verseText = remember { mutableStateOf("Carregando...") }

    LaunchedEffect(Unit) {
        val call = VersiclesApiService.ApiClient.retrofit.getRandomVerse()

        call.enqueue(object : Callback<VersiclesApiService.VerseResponse> {
            override fun onResponse(call: Call<VersiclesApiService.VerseResponse>, response: Response<VersiclesApiService.VerseResponse>) {
                if (response.isSuccessful) {
                    val verse = response.body()
                    verseText.value = "${verse?.book} ${verse?.chapter}:${verse?.verse} - ${verse?.text}"
                }
            }

            override fun onFailure(call: Call<VersiclesApiService.VerseResponse>, t: Throwable) {
                verseText.value = "Erro ao carregar versículo."
            }
        })
    }

    // Exibir o versículo na tela
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Corrigido aqui
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = verseText.value, style = MaterialTheme.typography.titleLarge)
    }
}
