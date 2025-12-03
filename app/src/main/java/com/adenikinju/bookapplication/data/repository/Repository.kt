package com.adenikinju.bookapplication.data.repository

import com.adenikinju.bookapplication.data.models.BooksModel

interface Repository {
    suspend fun getBooks(): BooksModel
}