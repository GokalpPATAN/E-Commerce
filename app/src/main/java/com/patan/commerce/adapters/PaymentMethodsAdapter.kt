package com.patan.commerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patan.commerce.databinding.ItempaymentsrecyclerviewBinding
import com.patan.commerce.model.PaymentCardResponses

class PaymentMethodsAdapter(
    private val cardDatas: PaymentCardResponses,
    private val cardClickListener: CardClickListener,
) : BaseAdapter<com.patan.commerce.model.GetPaymentCards, PaymentMethodsAdapter.ViewHolder>(
        cardDatas.paymentCards,
        cardClickListener,
    ) {
    class ViewHolder(
        val binding: ItempaymentsrecyclerviewBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder =
        ViewHolder(
            ItempaymentsrecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        val paymentCards = cardDatas.paymentCards
        val card = paymentCards?.get(position)
        bindTextView(holder.binding.tvCardNumber, card?.cardNumber)
        bindTextView(holder.binding.tvCardHolder, card?.cardName)
        bindTextView(holder.binding.tvCVV, card?.cvv)
        bindTextView(
            holder.binding.tvExpiryDate,
            card?.finishMonth.toString() + "/" + card?.finishYear.toString(),
        )

        holder.binding.deleteCardBtn.setOnClickListener { cardClickListener.onCardClicked(card?.id) }
    }

    override fun getItemCount(): Int {
        val paymentCards = cardDatas.paymentCards
        return paymentCards?.size ?: 0
    }
}
