package com.patan.commerce.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.patan.commerce.databinding.FragmentLoginBinding
import com.patan.commerce.databinding.FragmentRegisterBinding
import com.patan.commerce.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerButton.setOnClickListener {
            val userName = binding.userName.text?.toString()
            val password = binding.password.text.toString()
            val name: String? = binding.name.text?.toString()
            val surName: String? = binding.surName.text?.toString()
            val gender: String? = binding.gender.text?.toString()
            val phoneNumber: String? = binding.phone.text?.toString()
            val email: String? = binding.email.text?.toString()
            val repassword: String = binding.rePassword.text.toString()
            viewModel.register(name,userName,surName,gender,phoneNumber,email,password,repassword)
            val action = RegisterFragmentDirections.actionRegisterFragmentToConfirmEmailFragment()
            findNavController().navigate(action)
        }
    }
}