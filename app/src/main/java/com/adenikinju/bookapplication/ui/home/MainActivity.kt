package com.adenikinju.bookapplication.ui.home

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adenikinju.bookapplication.R
import com.adenikinju.bookapplication.data.adapter.BooksAdapter
import com.adenikinju.bookapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainActivityBinding: ActivityMainBinding

    private val viewModel: HomeViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.book.collectLatest {
                    when (it) {
                        is Result.Success -> {
                            mainActivityBinding.pbProgress.visibility = View.GONE
                            mainActivityBinding.rvBooks.adapter = BooksAdapter(it.value)
                            mainActivityBinding.rvBooks.layoutManager =
                                LinearLayoutManager(this@MainActivity)
                        }
                        is Result.Failure -> {}
                        Result.Loading -> {
                            mainActivityBinding.pbProgress.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }


    fun init() {
        viewModel.getBooks()
    }
}