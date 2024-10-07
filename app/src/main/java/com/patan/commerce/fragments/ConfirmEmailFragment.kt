package com.patan.commerce.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
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
            binding.apply {
                val approvedCode = mailConfirm.text.toString().toInt()
                val userName = userName.text.toString()
                viewModel.token.observe(viewLifecycleOwner) {
                    viewModel.confirmEmail(approvedCode, it, userName)
                }
                viewModel.success.observe(viewLifecycleOwner) { success ->
                    viewModel.notifications.observe(viewLifecycleOwner) {
                        if (success == false) {
                            Toast.makeText(
                                this@ConfirmEmailFragment.requireContext(),
                                it.toString(),
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {
                            Toast.makeText(
                                this@ConfirmEmailFragment.requireContext(),
                                it.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
            val action = ConfirmEmailFragmentDirections.actionConfirmEmailFragmentToLoginFragment()
            findNavController().navigate(action)
        }
        binding.reSend.setOnClickListener {
            val userName = binding.userName.text.toString()
            viewModel.reConfirmEmail(userName)
        }
    }
}