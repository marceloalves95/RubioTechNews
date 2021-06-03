package br.com.rubiotechnews.data.remote.model

import com.google.gson.annotations.SerializedName

data class Fonte(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val nome: String)
