package com.patan.commerce.fragments.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.patan.commerce.adapters.CardClickListener
import com.patan.commerce.adapters.PaymentsInOrderAdapter
import com.patan.commerce.databinding.FragmentPaymentMethodBinding
import com.patan.commerce.di.UserIdQualifier
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PaymentMethodFragment : BaseFragment<FragmentPaymentMethodBinding>(FragmentPaymentMethodBinding::inflate) {
    private val viewModel by viewModels<UserViewModel>()
    private lateinit var paymentAdapter: PaymentsInOrderAdapter

    @UserIdQualifier
    @Inject
    lateinit var userId: String

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveAddressButton.setOnClickListener {
            val cardName = binding.addCardName.text.toString()
            val cardNumber = binding.addCardNumber.text.toString()
            val finishMonth =
                binding.addfinishMonth.text
                    ?.toString()
                    ?.toInt()
            val finishYear =
                binding.addfinishYear.text
                    ?.toString()
                    ?.toInt()
            val ownerName = binding.addReceiverName.text.toString()
            val cvv = binding.addCVV.text.toString()
            viewModel.addPaymentCard(
                cardName,
                cardNumber,
                finishMonth,
                finishYear,
                cvv,
                ownerName,
                userId,
            )
        }
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.getPaymentCards(userId)
        viewModel._cardList.observe(viewLifecycleOwner) {
            paymentAdapter =
                PaymentsInOrderAdapter(
                    it,
                    object : CardClickListener {
                        override fun onCardClicked(cardId: String?) {
                            viewModel.deleteCard(cardId)
                        }
                    },
                )
            binding.recyclerView33.adapter = paymentAdapter
        }
    }
}
