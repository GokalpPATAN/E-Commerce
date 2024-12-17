package com.patan.commerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.patan.commerce.databinding.ItempaymentsinorderrecyclerviewBinding
import com.patan.commerce.model.PaymentCardResponses

class PaymentsInOrderAdapter(
    private val cardDatas: PaymentCardResponses,
    private val cardClickListener: CardClickListener,
) : BaseAdapter<com.patan.commerce.model.GetPaymentCards, PaymentsInOrderAdapter.ViewHolder>(cardDatas.paymentCards, cardClickListener) {
    private val _selectedCardId = MutableLiveData<String?>()
    val selectedCardId: MutableLiveData<String?> = _selectedCardId

    class ViewHolder(
        val binding: ItempaymentsinorderrecyclerviewBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder =
        ViewHolder(
            ItempaymentsinorderrecyclerviewBinding.inflate(
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
        holder.binding.root.setOnClickListener {
            val isChecked = holder.binding.checkBox2.isChecked
            holder.binding.checkBox2.isChecked = !isChecked
            if (!isChecked) {
                cardClickListener.onCardClicked(card?.id)
            } else {
                _selectedCardId.value = null
            }
        }
    }

    override fun getItemCount(): Int {
        val paymentCards = cardDatas.paymentCards
        return paymentCards?.size ?: 0
    }
}
