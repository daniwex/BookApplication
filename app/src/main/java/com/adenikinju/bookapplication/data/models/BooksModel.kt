package com.adenikinju.bookapplication.data.models


import com.google.gson.annotations.SerializedName

data class BooksModel(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("previous")
    val previous: Any? = null,
    @SerializedName("results")
    val results: List<ResultModel?>? = listOf()
)