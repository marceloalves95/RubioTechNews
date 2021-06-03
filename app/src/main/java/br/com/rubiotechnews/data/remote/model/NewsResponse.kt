package br.com.rubiotechnews.data.remote.model

data class NewsResponse(
    val articles: List<Artigo>,
    val status: String,
    val totalResults: Int
)