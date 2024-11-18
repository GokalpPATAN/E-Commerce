package com.patan.commerce.adapters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.icu.text.DecimalFormat
import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.patan.commerce.R
import com.patan.commerce.databinding.ItemproductsrecyclerviewBinding
import com.patan.commerce.model.Products

class ProductsAdapter(
    private val productsClickListener: ProductsClickListener
) : PagingDataAdapter<Products, ProductsAdapter.ViewHolder>(ProductDiffCallback()) {

    class ViewHolder(val binding: ItemproductsrecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemproductsrecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = getItem(position)

        holder.binding.textView2.text = product?.name
        holder.binding.textView3.text = "Fiyat:" + product?.price.toString() + "\n"
        holder.binding.textView4.text = DecimalFormat("#.##").format(product?.score).toString()

        val bitmap = Base64toBitmap(product?.ımages.toString())
        if (bitmap != null) {
            holder.binding.imageView2.setImageBitmap(bitmap)
        } else {
            holder.binding.imageView2.setImageResource(R.drawable.baseline_error_24)
        }

        holder.binding.root.setOnClickListener {
            productsClickListener.onProductClicked(
                productId = product?.ıd, productScoreCount = product?.scoreCount
            )
        }
    }

    private fun Base64toBitmap(base64String: String): Bitmap? {
        return try {
            val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            null
        }
    }
}

class ProductDiffCallback : DiffUtil.ItemCallback<Products>() {
    override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
        return oldItem.ıd == newItem.ıd
    }

    override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
        return oldItem == newItem
    }
}
