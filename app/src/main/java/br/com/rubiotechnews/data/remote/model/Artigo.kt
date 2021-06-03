package br.com.rubiotechnews.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by RubioAlves on 03/06/2021
 */
data class Artigo(
    @SerializedName("author")
    val author: Any,
    @SerializedName("content")
    val content: Any,
    @SerializedName("description")
    val description: Any,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("source")
    val source: Fonte,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String)

