package com.adenikinju.bookapplication.data.network

import com.adenikinju.bookapplication.data.models.BooksModel
import retrofit2.http.GET

interface ApiInterface {
    @GET("/books")
    suspend fun getBooks(): BooksModel
}