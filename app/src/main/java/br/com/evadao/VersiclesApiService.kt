package br.com.evadao

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Call


class VersiclesApiService {
    // Definir a interface do serviço
    interface VerseApiService {
        @GET("https://bible-api.com/john 3:16")  // Substitua pelo endpoint correto da sua API
        fun getRandomVerse(): Call<VerseResponse>
    }

    // Definir o modelo de dados que vai representar a resposta
    data class VerseResponse(
        val book: String,
        val chapter: Int,
        val verse: Int,
        val text: String
    )

    // Instanciar o Retrofit
    object ApiClient {
        private const val BASE_URL = "https://bible-api.com/john 3:16"

        val retrofit: VerseApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VerseApiService::class.java)
        }
    }
}

