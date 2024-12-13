package com.patan.commerce.fragments.user

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.patan.commerce.adapters.CitiesAdapter
import com.patan.commerce.adapters.CitiesClickListener
import com.patan.commerce.databinding.FragmentAddAdressBinding
import com.patan.commerce.di.UserIdQualifier
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.model.AddAddressRequest
import com.patan.commerce.viewmodels.AddressViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AddAddressFragment : BaseFragment<FragmentAddAdressBinding>(FragmentAddAdressBinding::inflate) {
    private val viewModel by viewModels<AddressViewModel>()
    private lateinit var citiesAdapter: CitiesAdapter
    private lateinit var districtAdapter: CitiesAdapter

    @UserIdQualifier
    @Inject
    lateinit var userId: String
    private var cityId: Int? = null
    private var districtId: Int? = null

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        val pref = activity?.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE)
        val editor = pref?.edit()
        visibilityChanger()
        observeEvents(editor)

        binding.saveAddressButton.setOnClickListener {
            val addressTitle = binding.phoneEdit.text.toString()
            val name = binding.descEdit.text.toString()
            val phone = binding.editPhoneNumber.text.toString()
            val desc = binding.editEmail.text.toString()

            binding.textView6.text = addressTitle
            binding.textView8.text = name
            binding.textView10.text = phone
            binding.textView11.text = desc
            val address =
                AddAddressRequest(addressTitle, name, phone, userId, cityId, districtId, desc)
            viewModel.addAddress(address)
            bindAddressTextVisible(binding.textView6, binding.phoneEdit, true)
            bindAddressTextVisible(binding.textView8, binding.descEdit, true)
            bindAddressTextVisible(binding.textView10, binding.editPhoneNumber, true)
            bindAddressTextVisible(binding.textView11, binding.editEmail, true)
        }
    }

    private fun observeEvents(editor: SharedPreferences.Editor?) {
        viewModel.getCities()
        lifecycleScope.launch {
            viewModel.citiesList.collect { city ->
                citiesAdapter =
                    CitiesAdapter(
                        city,
                        object : CitiesClickListener {
                            override fun onCitiesClicked(
                                citiesId: Int?,
                                city: String?,
                            ) {
                                binding.textView5.text = city
                                cityId = citiesId
                                editor?.putInt("cityId", cityId!!)
                                editor?.commit()
                                viewModel.getDistrict(citiesId)
                                lifecycleScope.launch {
                                    viewModel.citiesList.collect { district ->
                                        districtAdapter =
                                            CitiesAdapter(
                                                district,
                                                object : CitiesClickListener {
                                                    override fun onCitiesClicked(
                                                        citiesId: Int?,
                                                        city: String?,
                                                    ) {
                                                        binding.textView7.text = city
                                                        districtId = citiesId
                                                        editor?.putInt("districtId", districtId!!)
                                                        editor?.commit()
                                                        binding.recyclerView5.isVisible = false
                                                    }
                                                },
                                            )
                                        binding.recyclerView5.adapter = districtAdapter
                                    }
                                }
                            }
                        },
                    )
                binding.recyclerView5.adapter = citiesAdapter
            }
        }
    }

    private fun bindAddressTextVisible(
        textView: TextView,
        editText: EditText,
        visible: Boolean,
    ) {
        textView.isVisible = visible
        editText.isVisible = !visible
    }

    private fun visibilityChanger() {
        binding.apply {
            textView6.setOnClickListener {
                bindAddressTextVisible(it as TextView, binding.phoneEdit, false)
            }
            textView8.setOnClickListener {
                bindAddressTextVisible(it as TextView, binding.descEdit, false)
            }
            textView10.setOnClickListener {
                bindAddressTextVisible(it as TextView, binding.editPhoneNumber, false)
            }
            binding.textView11.setOnClickListener {
                bindAddressTextVisible(it as TextView, binding.editEmail, false)
            }
        }
    }
}
