package com.example.geeks_3_finalproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.geeks_3_finalproject.Category
import com.example.geeks_3_finalproject.R


class CategoryAdapter(var arrayList: ArrayList<Category>) : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(arrayList[position])
    }

}

class CategoryViewHolder(itemView: View) : ViewHolder(itemView) {

    var image : ImageView = itemView.findViewById(R.id.image_view_mini_hamb)
    var title : TextView = itemView.findViewById(R.id.text_view_title)

    fun onBind(category: Category) {
        image.setImageResource(category.image)
        title.text = category.title
    }

}