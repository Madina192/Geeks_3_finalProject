package com.example.geeks_3_finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.geeks_3_finalproject.adapter.CategoryAdapter
import com.example.geeks_3_finalproject.adapter.ProductAdapter
import com.example.geeks_3_finalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var arrayList: ArrayList<Category>
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var categoryRecyclerView: RecyclerView
    lateinit var binding: ActivityMainBinding

    lateinit var productAdapter : ProductAdapter
    lateinit var productRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapters()
    }

    private fun setCategory(): ArrayList<Category> {
        return arrayListOf(
            Category(R.drawable.img_mini_hamb, "Takeaways"),
            Category(R.drawable.img_vegetables, "Grocery"),
            Category(R.drawable.img_brush, "Convenience"),
            Category(R.drawable.img_pharmacy, "Pharmacy")
        )
    }

    private fun setProducts() : ArrayList<Product> {
        return arrayListOf(
            Product("Burger Craze", R.drawable.img_hamburger, true, 4.6, 601, "American", "Burgers", "FREE", "$10", "15-20 min", "1.5 km"),
            Product("Vegetarian Pizza", R.drawable.img_pizza, false, 4.6, 784, "Italian", "Burgers", "FREE", "$10", "10-15 min", "0.8 km"),
            Product("Fried Chicken", R.drawable.chicken, true, 4.8, 460, "Kentucky", "Fast Food", "10%", "$13", "20-25 min", "2.3 km"),
            Product("Indian Samosa", R.drawable.img_hamburger, false, 4.5, 537, "Indian", "Foods", "$5", "$8", "15-20 min", "1.4 km"),
            Product("Pepperoni Pizza", R.drawable.img_pizza, true, 3.9, 893, "French", "Pizzas", "FREE", "$9", "5-10 min", "0.2 km"),
        )
    }

    private fun setAdapters(){
        categoryAdapter = CategoryAdapter(setCategory())
        categoryRecyclerView = binding.recyclerViewCategory
        categoryRecyclerView.adapter = categoryAdapter

        productAdapter = ProductAdapter(setProducts()) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }
        productRecyclerView = binding.recyclerViewProducts
        productRecyclerView.adapter = productAdapter
    }

}