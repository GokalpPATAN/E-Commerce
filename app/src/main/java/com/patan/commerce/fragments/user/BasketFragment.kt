package com.patan.commerce.fragments.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.patan.commerce.databinding.FragmentBasketBinding
import com.patan.commerce.di.UserIdQualifier
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BasketFragment : BaseFragment<FragmentBasketBinding>(FragmentBasketBinding::inflate) {
    private val viewModel by viewModels<ProductsViewModel>()
    @UserIdQualifier
    @Inject
    lateinit var userId:String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}