package com.patan.commerce.fragments.products

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.patan.commerce.adapters.CategoryAdapter
import com.patan.commerce.adapters.CategoryClickListener
import com.patan.commerce.adapters.ProductsAdapter
import com.patan.commerce.adapters.ProductsClickListener
import com.patan.commerce.databinding.FragmentCategoriesBinding
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate) {
    private val viewModel by viewModels<ProductsViewModel>()
    private lateinit var categoriesAdapter: CategoryAdapter
    private lateinit var productsAdapter: ProductsAdapter
    private val args: CategoriesFragmentArgs by navArgs()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        val topCategoryId = args.topCategoryId

        viewModel.getTopCategories(topCategoryId)
        viewModel._topCategoriesList.observe(viewLifecycleOwner) {
            Log.d("CategoriesFragment", "Successful: $it")
            categoriesAdapter =
                CategoryAdapter(
                    it,
                    object : CategoryClickListener {
                        override fun onCategoryClicked(topCategoryId: Int?) {
                            binding.recyclerView3.isVisible = false
                            binding.recyclerView4.isVisible = true
                            viewModel.getTopCategories(topCategoryId)
                            viewModel._topCategoriesList.observe(viewLifecycleOwner) { subId ->
                                categoriesAdapter =
                                    CategoryAdapter(
                                        subId,
                                        object : CategoryClickListener {
                                            override fun onCategoryClicked(topCategoryId: Int?) {
                                                lifecycleScope.launch {
                                                    viewModel
                                                        .getProductsByCategory(
                                                            topCategoryId!!,
                                                            6,
                                                            0,
                                                        ).collectLatest {
                                                            viewModel._products.observe(
                                                                viewLifecycleOwner,
                                                            ) { prod ->
                                                                productsAdapter =
                                                                    ProductsAdapter(
                                                                        object :
                                                                            ProductsClickListener {
                                                                            override fun onProductClicked(
                                                                                productId: Int?,
                                                                                productScoreCount: Int?,
                                                                            ) {
                                                                                // Unnecessary part
                                                                            }
                                                                        },
                                                                        prod,
                                                                    )
                                                            }
                                                        }
                                                }
                                                binding.recyclerView4.adapter = productsAdapter
                                            }
                                        },
                                    )
                                binding.recyclerView4.adapter = categoriesAdapter
                            }
                        }
                    },
                )
            binding.recyclerView3.adapter = categoriesAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
