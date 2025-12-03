package com.adenikinju.bookapplication.data.models


import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("authors")
    val authors: List<AuthorModel?>? = listOf(),
    @SerializedName("bookshelves")
    val bookshelves: List<String?>? = listOf(),
    @SerializedName("copyright")
    val copyright: Boolean? = false,
    @SerializedName("download_count")
    val downloadCount: Int? = 0,
    @SerializedName("editors")
    val editors: List<Any?>? = listOf(),
    @SerializedName("formats")
    val formats: FormatsModel? = FormatsModel(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("languages")
    val languages: List<String?>? = listOf(),
    @SerializedName("media_type")
    val mediaType: String? = "",
    @SerializedName("subjects")
    val subjects: List<String?>? = listOf(),
    @SerializedName("summaries")
    val summaries: List<String?>? = listOf(),
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("translators")
    val translators: List<TranslatorModel?>? = listOf()
)