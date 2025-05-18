package com.example.shoppingmart.data

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoppingmart.databinding.ItemProductBinding
import com.squareup.picasso.Picasso
import timber.log.Timber

class ProductAdapter(private val products: List<data.Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        holder.binding.apply {
            textViewTitle.text = product.title.toString()
            textViewDescription.text = product.description
            textViewPrice.text = "Price: $${product.price}"
            ratingBar.rating = product.rating?.toFloat() ?: 0f
            productStock.text=product.stock.toString()


            Timber.tag("tittle").d(product.title.toString())
            Log.d("svg",product.title.toString())

            Glide.with(productImage.context)
                .load(product.thumbnail)
                .into(productImage)


        }
    }

    override fun getItemCount(): Int = products.size
}
