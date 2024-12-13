package com.patan.commerce.fragments.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.patan.commerce.adapters.AddressClickListener
import com.patan.commerce.adapters.AddressesInOrderAdapter
import com.patan.commerce.adapters.CardClickListener
import com.patan.commerce.adapters.PaymentsInOrderAdapter
import com.patan.commerce.databinding.FragmentOrderBinding
import com.patan.commerce.di.UserIdQualifier
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.model.SaveOrderRequest
import com.patan.commerce.viewmodels.AddressViewModel
import com.patan.commerce.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class OrderFragment : BaseFragment<FragmentOrderBinding>(FragmentOrderBinding::inflate) {
    private val viewModelAddress by viewModels<AddressViewModel>()
    private val viewModelUser by viewModels<UserViewModel>()
    private lateinit var paymentAdapter: PaymentsInOrderAdapter
    private lateinit var addressAdapter: AddressesInOrderAdapter
    private val args: OrderFragmentArgs by navArgs()

    @UserIdQualifier
    @Inject
    lateinit var userId: String

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        observeEvents()
        binding.saveButton.setOnClickListener { observeEvents() }
    }

    private fun observeEvents() {
        viewModelAddress.getAddresses(userId)
        lifecycleScope.launch {
            viewModelAddress.addressesList.collect { addresses ->
                addressAdapter =
                    AddressesInOrderAdapter(
                        addresses,
                        object : AddressClickListener {
                            override fun onAddressClicked(addressId: Int?) {
                                println(addressId)
                                viewModelUser.getPaymentCards(userId)
                                viewModelUser._cardList.observe(viewLifecycleOwner) {
                                    paymentAdapter =
                                        PaymentsInOrderAdapter(
                                            it,
                                            object : CardClickListener {
                                                override fun onCardClicked(cardId: String?) {
                                                    val selectedAddress = addressId.toString()
                                                    val itemList =
                                                        args.items.items.mapNotNull { item -> item?.cardItemId }
                                                    val request =
                                                        SaveOrderRequest(
                                                            userId,
                                                            selectedAddress,
                                                            cardId?.toInt(),
                                                            itemList,
                                                            null,
                                                            null,
                                                        )
                                                    println("merhaba")
                                                    binding.saveButton.setOnClickListener {
                                                        println("Request data: $request")
                                                        viewModelUser.saveOrder(request)
                                                        viewModelUser.deleteCard(userId)
                                                    }
                                                }
                                            },
                                        )
                                    binding.paymentsInOrderView.adapter = paymentAdapter
                                }
                            }

                            override fun onAddressUpdated(
                                addressId: Int?,
                                cityName: String?,
                                countyName: String?,
                                description: String?,
                                addressName: String?,
                                receiverName: String?,
                                receiverPhone: String?,
                            ) {
                                fun emptyOnPurpose() {
                                    // it will be improve on later versions
                                }
                            }
                        },
                    )
                binding.addressesInOrderView.adapter = addressAdapter
            }
        }
        viewModelUser.getPaymentCards(userId)
        viewModelUser._cardList.observe(viewLifecycleOwner) {
            paymentAdapter =
                PaymentsInOrderAdapter(
                    it,
                    object : CardClickListener {
                        override fun onCardClicked(cardId: String?) {
                            println(cardId)
                        }
                    },
                )
            binding.paymentsInOrderView.adapter = paymentAdapter
        }
    }
}
