package com.example.stario.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.stario.R
import com.example.stario.network.Planet

class ItemAdapter(private val context: Context, private val dataset: ArrayList<Planet>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.film_img)
        val textView: TextView = view.findViewById(R.id.text_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.imageUrl

        val imgUri = item.imageUrl.toUri().buildUpon().scheme("https").build()
        holder.imageView.load(imgUri)
        println(item)
        println(imgUri)
    }

    fun updateData(newData: List<Planet>) {
        dataset.clear()
        dataset.addAll(newData)
        notifyDataSetChanged()
    }
}
