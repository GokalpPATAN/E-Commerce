package com.patan.commerce.fragments.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.patan.commerce.databinding.FragmentResetPasswordBinding
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : BaseFragment<FragmentResetPasswordBinding>(FragmentResetPasswordBinding::inflate) {
    private val viewModel by viewModels<LoginViewModel>()
    private val args: ResetPasswordFragmentArgs by navArgs()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        val tokenReset = args.tokenReset

        binding.submitResetPassword.setOnClickListener {
            val approvedCode =
                binding.inputApprovedCode.text
                    .toString()
                    .toInt()
            val username = binding.inputUserName.text.toString()
            val password = binding.inputPassword.text.toString()
            val rePassword = binding.inputRePassword.text.toString()
            viewModel.resetPassword(approvedCode, tokenReset, username, password, rePassword)
        }
    }
}
