package br.com.rubiotechnews.data.remote.api

import br.com.rubiotechnews.data.remote.model.Artigo
import br.com.rubiotechnews.data.remote.model.NewsResponse
import br.com.rubiotechnews.utilities.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by RubioAlves on 03/06/2021
 */
interface NewsApi {

    @GET("top-headlines?country=br")
    suspend fun getNews(
        @Query("category") category: String = "technology",
        @Query("apiKey") apiKey: String = API_KEY): Response<NewsResponse>

}