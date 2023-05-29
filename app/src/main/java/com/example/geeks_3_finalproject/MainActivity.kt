package com.example.geeks_3_finalproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.geeks_3_finalproject.adapter.CategoryAdapter
import com.example.geeks_3_finalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var arrayList : ArrayList<Category>
    lateinit var adapter : CategoryAdapter
    lateinit var recyclerView : RecyclerView
    lateinit var binding : ActivityMainBinding
    var isDeliveryClicked : Boolean = false
    var isPickUpClicked : Boolean = false
    var isCateringClicked : Boolean = false
    var isCurbsideClicked : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = CategoryAdapter(setCategory())
        recyclerView = findViewById(R.id.recyclerView_category)
        recyclerView.adapter = adapter
        changeColor(binding.buttonDelivery)
        changeColor(binding.buttonPickUp)
        changeColor(binding.buttonCatering)
        changeColor(binding.buttonCurbside)
    }

    private fun setCategory(): ArrayList<Category> {
        return arrayListOf(
            Category(R.drawable.img_mini_hamb, "Takeaways"),
            Category(R.drawable.img_mini_hamb, "Grocery"),
            Category(R.drawable.img_mini_hamb, "Convenience"),
            Category(R.drawable.img_mini_hamb, "Pharmacy")
            )
    }

    @SuppressLint("ResourceAsColor")
    private fun changeColor(button : AppCompatButton) {
        button.setOnClickListener {
            when (button) {
                binding.buttonDelivery -> {
                    isDeliveryClicked = true
                    if(isDeliveryClicked) {
                        button.background = ResourcesCompat.getDrawable(resources, R.drawable.button_bg_on_click, null)
                        button.setTextColor(resources.getColor(R.color.white, null))
                    } else {
                        button.background = ResourcesCompat.getDrawable(resources, R.drawable.button_category, null)
                        button.setTextColor(resources.getColor(R.color.dark_green, null))
                    }
                }
                binding.buttonPickUp -> {
                    button.background = ResourcesCompat.getDrawable(resources, R.drawable.button_bg_on_click, null)
                    button.setTextColor(resources.getColor(R.color.white, null))
                    isPickUpClicked = true
                }
                binding.buttonCatering -> {
                    button.background = ResourcesCompat.getDrawable(resources, R.drawable.button_bg_on_click, null)
                    button.setTextColor(resources.getColor(R.color.white, null))
                    isCateringClicked = true
                }
                binding.buttonCurbside -> {
                    button.background = ResourcesCompat.getDrawable(resources, R.drawable.button_bg_on_click, null)
                    button.setTextColor(resources.getColor(R.color.white, null))
                    isCurbsideClicked = true
                }
            }
        }
    }

}