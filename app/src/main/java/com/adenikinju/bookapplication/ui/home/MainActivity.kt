package com.adenikinju.bookapplication.ui.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.adenikinju.bookapplication.R
import com.adenikinju.bookapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }


    fun initAdapter() {
        mainActivityBinding.rvBooks.adapter
    }
}