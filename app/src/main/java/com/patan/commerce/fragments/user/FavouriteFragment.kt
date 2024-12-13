package com.patan.commerce.fragments.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.patan.commerce.adapters.FavouriteAdapter
import com.patan.commerce.databinding.FragmentFavouriteBinding
import com.patan.commerce.di.UserIdQualifier
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavouriteFragment : BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate) {
    @UserIdQualifier
    @Inject
    lateinit var userId: String
    private lateinit var productsAdapter: FavouriteAdapter
    private val viewModel by viewModels<ProductsViewModel>()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.getFavourite(userId)
        viewModel._products.observe(viewLifecycleOwner) {
            productsAdapter = FavouriteAdapter(it)
            binding.recyclerView15.adapter = productsAdapter
        }
    }
}
