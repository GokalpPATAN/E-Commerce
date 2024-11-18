package com.patan.commerce.fragments.user

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.patan.commerce.adapters.AddressAdapter
import com.patan.commerce.adapters.AddressClickListener
import com.patan.commerce.databinding.FragmentEditAdressBinding
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.viewmodels.AddressViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EditAddressFragment :
    BaseFragment<FragmentEditAdressBinding>(FragmentEditAdressBinding::inflate) {
    private val viewModel by viewModels<AddressViewModel>()
    private lateinit var addressAdapter: AddressAdapter
    private lateinit var userIdGlobal: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = activity?.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE)
        userIdGlobal = pref?.getString("userId", "default").toString()
        val cityId = pref?.getInt("cityId", 0)
        val countyId = pref?.getInt("districtId", 0)
        viewModel.getAddresses(userIdGlobal)
        observeEvents( cityId, countyId)

    }

    private fun observeEvents( cityId: Int?, countyId: Int?) {
        lifecycleScope.launch {
            viewModel.addressesList.collect { addresses ->
                addressAdapter = AddressAdapter(addresses, object : AddressClickListener {
                    override fun onAddressClicked(addressId: Int?) {
                        viewModel.getAddresses(userIdGlobal)
                        observeEvents(cityId, countyId)
                    }

                    override fun onAddressUpdated(
                        addressId: Int?,
                        cityName: String?,
                        countyName: String?,
                        description: String?,
                        addressName: String?,
                        receiverName: String?,
                        receiverPhone: String?
                    ) {
                        viewModel.updateAddress(

                            addressId,
                            addressName,
                            receiverName,
                            receiverPhone,
                            userIdGlobal,
                            cityId,
                            countyId,
                            description
                        )
                    }
                })
                binding.recyclerView.adapter = addressAdapter
            }
        }
    }
}

