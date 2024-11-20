package br.com.evadao.Versiculos

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Call

class VersiclesApiService {
    interface VerseApiService {
        @GET("{verse}")
        fun getRandomVerse(
            @Path("verse") verse: String,
            @Query("translation") translation: String = "almeida"
        ): Call<VerseResponse>
    }

    data class VerseResponse(
        val reference: String,
        val text: String
    )

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