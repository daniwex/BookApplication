package com.adenikinju.bookapplication.data.models


import com.google.gson.annotations.SerializedName

data class TranslatorModel(
    @SerializedName("birth_year")
    val birthYear: Int? = 0,
    @SerializedName("death_year")
    val deathYear: Int? = 0,
    @SerializedName("name")
    val name: String? = ""
)