package com.adenikinju.bookapplication.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adenikinju.bookapplication.data.models.ResultModel
import com.adenikinju.bookapplication.databinding.BookBinding

class BooksAdapter(
   val listItems: List<ResultModel?>?
): RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BooksViewHolder {
        val binding = BookBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return BooksViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BooksViewHolder,
        position: Int
    ) {
        val d = holder.apply {
           title.text = listItems?.get(position)?.title
           id.text = listItems?.get(position)?.id.toString()
        }

    }

    override fun getItemCount(): Int {
        return listItems?.size?:0
    }


    inner class BooksViewHolder(view: BookBinding): RecyclerView.ViewHolder(view.root) {
        val title = view.tvTitle
        val id = view.tvAuthor
        val price = view.tvPrice
    }
}