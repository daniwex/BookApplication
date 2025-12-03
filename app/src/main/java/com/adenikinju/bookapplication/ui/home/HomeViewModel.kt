package com.adenikinju.bookapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adenikinju.bookapplication.data.models.BooksModel
import com.adenikinju.bookapplication.data.models.ResultModel
import com.adenikinju.bookapplication.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _books = MutableStateFlow<Result<List<ResultModel?>?>>(Result.Loading)
    val book = _books.asStateFlow()


     fun getBooks() {
        viewModelScope.launch {
            _books.value = Result.Loading
            try {
                _books.value = Result.Success(repository.getBooks().results)
                } catch (e: Exception) {
                _books.value = Result.Failure(e)
            }
        }
    }


}


sealed class Result<out T> {
    data class Success<out R>(val value: R): Result<R>()
    data class Failure(val error: Throwable): Result<Nothing>()
    object Loading: Result<Nothing>()
}