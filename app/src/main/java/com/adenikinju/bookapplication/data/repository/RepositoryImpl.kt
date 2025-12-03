package com.adenikinju.bookapplication.data.repository

import com.adenikinju.bookapplication.data.models.BooksModel
import com.adenikinju.bookapplication.data.network.ApiInterface
import jakarta.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
): Repository {
    override suspend fun getBooks(): BooksModel {
       return  apiInterface.getBooks()
    }
}