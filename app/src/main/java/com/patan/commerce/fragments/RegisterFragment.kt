package com.patan.commerce.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.patan.commerce.R
import com.patan.commerce.databinding.FragmentRegisterBinding
import com.patan.commerce.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerButton.setOnClickListener {
            binding.apply {
                val userName = userName.text?.toString()
                val password = password.text.toString()
                val name: String? = name.text?.toString()
                val surName: String? = surName.text?.toString()
                val gender: String? = gender.text?.toString()
                val phoneNumber: String? = phone.text?.toString()
                val email: String? = email.text?.toString()
                val repassword: String = rePassword.text.toString()
                viewModel.register(
                    name, userName, surName, gender, phoneNumber, email, password, repassword
                )
                viewModel.success.observe(viewLifecycleOwner) { success ->
                    if (success == false) {
                        viewModel.notifications.observe(viewLifecycleOwner) {
                            Toast.makeText(
                                this@RegisterFragment.requireContext(),
                                it.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            this@RegisterFragment.requireContext(),
                            getString(R.string.kayit_basarili),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }
            val action = RegisterFragmentDirections.actionRegisterFragmentToConfirmEmailFragment()
            findNavController().navigate(action)
        }
    }
}