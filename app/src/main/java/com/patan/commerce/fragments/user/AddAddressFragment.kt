package com.patan.commerce.fragments.user

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.patan.commerce.adapters.CitiesAdapter
import com.patan.commerce.adapters.CitiesClickListener
import com.patan.commerce.databinding.FragmentAddAdressBinding
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.viewmodels.AddressViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddAddressFragment :
    BaseFragment<FragmentAddAdressBinding>(FragmentAddAdressBinding::inflate) {

    private val viewModel by viewModels<AddressViewModel>()
    private lateinit var citiesAdapter: CitiesAdapter
    private lateinit var districtAdapter: CitiesAdapter

    private var cityId: Int? = null
    private var districtId: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = activity?.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE)
        val editor = pref?.edit()
        val userId = pref?.getString("userId", "default")

        observeEvents(editor)

        binding.saveAddressButton.setOnClickListener {
            val addressTitle = binding.addressEdit.text.toString()
            val name = binding.receiverEdit.text.toString()
            val phone = binding.phoneEdit.text.toString()
            val desc = binding.descEdit.text.toString()
            viewModel.addAddress(addressTitle, name, phone, userId, cityId, districtId, desc)
        }


    }

    private fun observeEvents(editor: SharedPreferences.Editor?) {
        viewModel.getCities()
        lifecycleScope.launch {
            viewModel.citiesList.collect { city ->
                citiesAdapter = CitiesAdapter(city, object : CitiesClickListener {
                    override fun onCitiesClicked(citiesId: Int?, city: String?) {
                        binding.cityTextView.text = city
                        cityId = citiesId
                        editor?.putInt("cityId", cityId!!)
                        editor?.commit()
                        viewModel.getDistrict(citiesId)
                        lifecycleScope.launch {
                            viewModel.citiesList.collect { district ->
                                districtAdapter =
                                    CitiesAdapter(district, object : CitiesClickListener {
                                        override fun onCitiesClicked(
                                            citiesId: Int?, city: String?
                                        ) {
                                            binding.textView9.text = city
                                            districtId = citiesId
                                            editor?.putInt("districtId", districtId!!)
                                            editor?.commit()
                                            binding.recyclerView5.isVisible = false
                                        }
                                    })
                                binding.recyclerView5.adapter = districtAdapter
                            }
                        }
                    }
                })
                binding.recyclerView5.adapter = citiesAdapter

            }
        }
    }

}