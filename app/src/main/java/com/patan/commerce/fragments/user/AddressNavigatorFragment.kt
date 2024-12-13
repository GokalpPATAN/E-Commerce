package com.patan.commerce.fragments.user

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.patan.commerce.databinding.FragmentAddressNavigatorBinding
import com.patan.commerce.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddressNavigatorFragment : BaseFragment<FragmentAddressNavigatorBinding>(FragmentAddressNavigatorBinding::inflate) {
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.itemAddAddress.setOnClickListener {
            val action =
                AddressNavigatorFragmentDirections.actionAddressNavigatorFragmentToAddAddressFragment()
            findNavController().navigate(action)
        }

        binding.itemEditAddresses.setOnClickListener {
            val action =
                AddressNavigatorFragmentDirections.actionAddressNavigatorFragmentToEditAddressFragment()
            findNavController().navigate(action)
        }
    }
}
