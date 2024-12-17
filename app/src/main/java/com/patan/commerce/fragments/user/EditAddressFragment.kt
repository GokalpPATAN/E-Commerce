package com.patan.commerce.fragments.user

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.patan.commerce.adapters.AddressAdapter
import com.patan.commerce.adapters.AddressClickListener
import com.patan.commerce.databinding.FragmentEditAdressBinding
import com.patan.commerce.di.UserIdQualifier
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.model.UpdateAddressRequest
import com.patan.commerce.viewmodels.AddressViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class EditAddressFragment : BaseFragment<FragmentEditAdressBinding>(FragmentEditAdressBinding::inflate) {
    private val viewModel by viewModels<AddressViewModel>()
    private lateinit var addressAdapter: AddressAdapter

    @UserIdQualifier
    @Inject
    lateinit var userId: String

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        val pref = activity?.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE)

        val cityId = pref?.getInt("cityId", 0)
        val countyId = pref?.getInt("districtId", 0)
        viewModel.getAddresses(userId)
        observeEvents(cityId, countyId)
    }

    private fun observeEvents(
        cityId: Int?,
        countyId: Int?,
    ) {
        lifecycleScope.launch {
            viewModel.addressesList.collect { addresses ->
                addressAdapter =
                    AddressAdapter(
                        addresses,
                        object : AddressClickListener {
                            override fun onAddressClicked(addressId: Int?) {
                                viewModel.getAddresses(userId)
                                observeEvents(cityId, countyId)
                                viewModel.deleteAddress(addressId)
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
                                val address =
                                    UpdateAddressRequest(
                                        addressId,
                                        description,
                                        cityId,
                                        countyId,
                                        addressName,
                                        receiverName,
                                        receiverPhone,
                                        userId,
                                    )
                                viewModel.updateAddress(address)
                            }
                        },
                    )
                binding.recyclerView.adapter = addressAdapter
            }
        }
    }
}
