package br.com.evadao

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

@Preview(showBackground = true)
@Composable
fun PreviewVerseScreen() {
    // Chame a função VerseScreen para exibir no preview
    VerseScreen()
}
