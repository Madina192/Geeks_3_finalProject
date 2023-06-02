package com.example.geeks_3_finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.geeks_3_finalproject.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    lateinit var product : Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        product = intent.getParcelableExtra("product")!!
        setViews()
    }

    private fun setViews(){
        binding.imageViewImage.setImageResource(product.image)
        binding.textViewName.text = product.name
        binding.textViewRate.text = product.rate.toString()
        binding.textViewParticipants.text = product.parts.toString()
        binding.textViewCategory.text = product.category
        binding.textViewPlace.text = product.place
        binding.textViewDelivery.text = product.delivery
        binding.textViewMinPrice.text = product.minPrice
        binding.textViewDistance.text = product.distance
        setDiscount()
    }

    private fun setDiscount() {
        if(product.discount) {
            binding.textViewDiscount.visibility = RecyclerView.VISIBLE
        } else {
            binding.textViewDiscount.visibility = RecyclerView.GONE
        }
    }
}