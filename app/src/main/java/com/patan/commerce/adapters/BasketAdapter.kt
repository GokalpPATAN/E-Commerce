package com.patan.commerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patan.commerce.databinding.ItembasketrecyclerviewBinding
import com.patan.commerce.model.CardItem
import com.patan.commerce.model.CardItems
import com.patan.commerce.model.CartData

class BasketAdapter(
    private val cart: CartData,
    private val onBasketClickListener: BasketClickListener,
) : BaseAdapter<CardItem, BasketAdapter.ViewHolder>(cart.cardItems, onBasketClickListener) {
    class ViewHolder(
        val binding: ItembasketrecyclerviewBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder =
        ViewHolder(
            ItembasketrecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun getItemCount(): Int = cart.cardItems?.size ?: 0

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        val product = cart.cardItems!![position]

        bindTextView(holder.binding.productName, product.productName)
        bindTextView(holder.binding.productPrice, product.price.toString())
        bindTextView(holder.binding.productQuantity, product.quantity.toString())

        holder.binding.removeItemIcon.setOnClickListener {
            onBasketClickListener.onBasketClicked(
                product.cardItemId,
            )
        }
    }

    fun calculateTotalBasketPrice(): Int {
        var totalPrice = 0

        cart.cardItems?.forEach { product ->
            totalPrice += product.price ?: 0
        }

        return totalPrice
    }

    fun findItems(): List<CardItems> {
        val cartItemsforArgs = mutableListOf<CardItems>()
        cart.cardItems?.forEach {
            cartItemsforArgs += CardItems(it.cardItemId)
        }
        return cartItemsforArgs
    }
}
