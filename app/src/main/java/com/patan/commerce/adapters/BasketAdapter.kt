package com.patan.commerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patan.commerce.databinding.ItembasketrecyclerviewBinding
import com.patan.commerce.model.CardItem

class BasketAdapter(private val cartList: List<CardItem?>?) :
    RecyclerView.Adapter<BasketAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItembasketrecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItembasketrecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false

            )
        )
    }

    override fun getItemCount(): Int {
        return cartList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val products = cartList!![position]
        holder.binding.productName.text = products?.productName
        holder.binding.productPrice.text = products?.price.toString()
        holder.binding.productQuantity.text = products?.quantity.toString()
    }

}