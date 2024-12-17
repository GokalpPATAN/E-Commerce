package com.patan.commerce.fragments.user

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.patan.commerce.databinding.FragmentUserBinding
import com.patan.commerce.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate) {
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            itemAccountDetails.setOnClickListener {
                val action = UserFragmentDirections.actionUserFragmentToEditUserFragment()
                findNavController().navigate(action)
            }
            itemDeliveryAddresses.setOnClickListener {
                val action = UserFragmentDirections.actionUserFragmentToAddressNavigatorFragment()
                findNavController().navigate(action)
            }
            itemPaymentMethod.setOnClickListener {
                val action = UserFragmentDirections.actionUserFragmentToPaymentMethodFragment()
                findNavController().navigate(action)
            }
        }
    }
}
