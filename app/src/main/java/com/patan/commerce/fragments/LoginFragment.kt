package com.patan.commerce.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.patan.commerce.R
import com.patan.commerce.databinding.FragmentLoginBinding
import com.patan.commerce.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var sharedPreferences: SharedPreferences
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = activity?.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE)!!
        editor = sharedPreferences.edit()
        binding.loginButton.setOnClickListener {
            binding.apply {
                val userName = userName.text?.toString()
                val password = password.text.toString()
                viewModel.login(userName, password)
                viewModel.success.observe(viewLifecycleOwner) { success ->
                    if (success == false) {
                        viewModel.notifications.observe(viewLifecycleOwner) {
                            Toast.makeText(
                                this@LoginFragment.requireContext(),
                                it.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        viewModel.token.observe(viewLifecycleOwner) {
                            editor.putString("token", "Bearer $it")
                            editor.commit()
                        }
                        Toast.makeText(
                            this@LoginFragment.requireContext(),
                            getString(R.string.kullanici_girisi),
                            Toast.LENGTH_SHORT
                        ).show()
                        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment2()
                        findNavController().navigate(action)

                    }
                }

            }
        }
        binding.registerButton.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }
    }
}