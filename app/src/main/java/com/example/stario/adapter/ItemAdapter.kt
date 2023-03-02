package com.example.stario.adapter

import android.content.Context
import android.view.TextureView
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.stario.R

class ItemAdapter (private val context: Context) {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextureView = view.findViewById(R.id.item_title)
    }
}