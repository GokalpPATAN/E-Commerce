package com.patan.commerce.fragments.products

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.patan.commerce.adapters.CategoryAdapter
import com.patan.commerce.adapters.CategoryClickListener
import com.patan.commerce.adapters.ProductsAdapter
import com.patan.commerce.adapters.ProductsClickListener
import com.patan.commerce.databinding.FragmentProductsBinding
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate) {
    private val viewModel by viewModels<ProductsViewModel>()
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var categoriesAdapter: CategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productsAdapter = ProductsAdapter(object : ProductsClickListener {
            override fun onProductClicked(productId: Int?, productScoreCount: Int?) {
                if (productId != null && productScoreCount != null) {
                    val action = ProductsFragmentDirections.actionProductsFragmentToProductDetailFragment2(
                        productId, productScoreCount
                    )
                    findNavController().navigate(action)
                }
            }
        })

        binding.recyclerView1.adapter = productsAdapter

        viewModel.getCategories()
        observeCategories()
        viewModel.getProducts()
        observeProducts()
    }

    private fun observeProducts() {
        lifecycleScope.launch {
            viewModel.getProducts().collectLatest { pagingData ->
                productsAdapter.submitData(pagingData)
            }
        }
    }

    private fun observeCategories() {
        viewModel._categoriesList.observe(viewLifecycleOwner) {
            categoriesAdapter = CategoryAdapter(it, object : CategoryClickListener {
                override fun onCategoryClicked(topCategoryId: Int?) {
                    if (topCategoryId != null) {
                        val action = ProductsFragmentDirections.actionProductsFragmentToCategoriesFragment(
                            topCategoryId
                        )
                        findNavController().navigate(action)
                    }
                }
            })
            binding.recyclerView2.adapter = categoriesAdapter
        }
    }
}
