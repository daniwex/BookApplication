package com.adenikinju.bookapplication.ui.home

import androidx.lifecycle.ViewModel
import com.adenikinju.bookapplication.data.repository.Repository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val books = MutableStateFlow()

}