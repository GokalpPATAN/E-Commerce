package com.patan.commerce.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.patan.commerce.databinding.FragmentHomeBinding
import com.patan.commerce.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = activity?.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE)
        val token = pref?.getString("token", "default")
        println(token)
        viewModel.getCities(token)
        viewModel._cities.observe(viewLifecycleOwner) { it?.forEach { println(it?.name) } }
    }
}