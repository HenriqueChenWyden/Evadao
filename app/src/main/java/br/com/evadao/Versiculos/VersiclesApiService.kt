package br.com.evadao.Versiculos

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

class VersiclesApiService {
    // Definir a interface do serviço com parâmetro dinâmico
    interface VerseApiService {
        @GET("{verse}")  // Usando um parâmetro dinâmico para o versículo
        fun getRandomVerse(@Path("verse") verse: String): Call<VerseResponse>
    }

    // Definir o modelo de dados que vai representar a resposta
    data class VerseResponse(
        val reference: String,
        val text: String
    )

    // Instanciar o Retrofit
    object ApiClient {
        private const val BASE_URL = "https://bible-api.com/"

        val retrofit: VerseApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VerseApiService::class.java)
        }
    }
}
