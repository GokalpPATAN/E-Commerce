package com.patan.commerce.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.patan.commerce.databinding.FragmentUserBinding
import com.patan.commerce.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate) {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}