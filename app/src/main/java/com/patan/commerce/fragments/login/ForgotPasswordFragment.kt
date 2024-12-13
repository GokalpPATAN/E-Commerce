package com.patan.commerce.fragments.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.patan.commerce.databinding.FragmentForgotPasswordBinding
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment : BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate) {
    private val viewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnForgotPasswordSubmit.setOnClickListener {
            val userName = binding.etForgotPasswordUsername.text.toString()
            val email = binding.etForgotPasswordEmail.text.toString()
            viewModel.forgotPassword(userName, email)
            viewModel.tokenFromReset.observe(viewLifecycleOwner) {
                val action =
                    ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToResetPasswordFragment(
                        it.toString(),
                    )
                findNavController().navigate(action)
            }
        }
    }
}
