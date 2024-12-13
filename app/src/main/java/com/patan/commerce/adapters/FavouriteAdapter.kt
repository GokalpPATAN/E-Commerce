package com.patan.commerce.adapters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.icu.text.DecimalFormat
import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.patan.commerce.R
import com.patan.commerce.databinding.ItemproductsrecyclerviewBinding
import com.patan.commerce.model.Products

class FavouriteAdapter(
    private val productsInfos: List<Products?>?,
) : RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {
    class ViewHolder(
        val binding: ItemproductsrecyclerviewBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder =
        ViewHolder(
            ItemproductsrecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun getItemCount(): Int = productsInfos!!.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        val product = productsInfos?.get(position)
        bindProductsField(holder.binding.textView2, product?.name)
        bindProductsField(holder.binding.textView3, "Fiyat:" + product?.price.toString() + "\n")
        bindProductsField(holder.binding.textView4, DecimalFormat("#.##").format(product?.score).toString())

        val bitmap = base64toBitmap(product?.images.toString())
        if (bitmap != null) {
            holder.binding.imageView2.setImageBitmap(bitmap)
        } else {
            holder.binding.imageView2.setImageResource(R.drawable.baseline_error_24)
        }
    }

    private fun base64toBitmap(base64String: String): Bitmap? =
        try {
            val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            null
        }

    private fun bindProductsField(
        textView: TextView,
        productValue: String?,
    ) {
        textView.text = productValue
    }
}
