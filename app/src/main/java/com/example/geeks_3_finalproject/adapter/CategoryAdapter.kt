package com.example.geeks_3_finalproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.geeks_3_finalproject.Category
import com.example.geeks_3_finalproject.databinding.ItemCategoryBinding


class CategoryAdapter(var arrayList: ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(arrayList[position])
    }

    inner class CategoryViewHolder(var binding : ItemCategoryBinding) : ViewHolder(binding.root) {
         private lateinit var image : ImageView
         lateinit var title : TextView
        private fun findViews(){
            image = binding.imageViewMiniHamb
            title = binding.textViewTitle
        }

        fun onBind(category: Category) {
            findViews()
            image.setImageResource(category.image)
            title.text = category.title
        }

    }

}

