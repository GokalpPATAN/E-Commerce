package com.patan.commerce.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.patan.commerce.databinding.FragmentLoginBinding
import com.patan.commerce.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            val userName = binding.userName.text?.toString()
            val password = binding.password.text.toString()
            viewModel.login(userName, password)
            viewModel.userInfos.observe(viewLifecycleOwner){
                println(it)
            }
            viewModel.token.observe(viewLifecycleOwner){
                println(it)
            }
            viewModel.responseNotifications.observe(viewLifecycleOwner){
                println(it)
            }
        }
        binding.registerButton.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }
    }
}