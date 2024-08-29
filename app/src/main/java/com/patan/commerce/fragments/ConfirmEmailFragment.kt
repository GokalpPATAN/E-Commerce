package com.patan.commerce.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.patan.commerce.databinding.FragmentConfirmEmailBinding
import com.patan.commerce.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfirmEmailFragment :
    BaseFragment<FragmentConfirmEmailBinding>(FragmentConfirmEmailBinding::inflate) {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.confirmButton.setOnClickListener {
            val approvedCode = binding.mailConfirm.text.toString().toInt()
            val userName = binding.userName.text.toString()
            viewModel.token.observe(viewLifecycleOwner){
            viewModel.confirmEmail(approvedCode, it, userName)}
            val action = ConfirmEmailFragmentDirections.actionConfirmEmailFragmentToLoginFragment()
            findNavController().navigate(action)
        }
        binding.reSend.setOnClickListener {
            val userName = binding.userName.text.toString()
            viewModel.reConfirmEmail(userName)
        }
    }
}