package com.patan.commerce.fragments.products

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.patan.commerce.R
import com.patan.commerce.adapters.CommentAdapter
import com.patan.commerce.databinding.FragmentProductDetailBinding
import com.patan.commerce.di.UserIdQualifier
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding>(FragmentProductDetailBinding::inflate) {
    private val viewModel by viewModels<ProductsViewModel>()
    private val args: ProductDetailFragmentArgs by navArgs()
    private lateinit var commentsAdapter: CommentAdapter

    @UserIdQualifier
    @Inject
    lateinit var userId: String
    private var quantity: Int = 0

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        val productId = args.productId
        val productScore = args.productScore
        viewModel.getProductDetails(productId, productScore)
        observeEvents()
        quantityFinder()
        binding.addToCart.setOnClickListener { viewModel.addToCart(userId, productId, quantity) }
        favouriteEvents(userId, productId)
        binding.postCommentButton.setOnClickListener { addComment(productId) }

        commentsAdapter = CommentAdapter()

        getComments(
            productId,
        )
        binding.commentsRecyclerView.adapter = commentsAdapter
    }

    private fun quantityFinder() {
        binding.decrementButton.setOnClickListener {
            quantity -= 1
            if (quantity < 0) {
                Toast
                    .makeText(
                        this@ProductDetailFragment.requireContext(),
                        "Product count can not negative",
                        Toast.LENGTH_SHORT,
                    ).show()
            } else {
                binding.counterTextView.text = quantity.toString()
            }
        }
        binding.incrementButton.setOnClickListener {
            quantity += 1
            binding.counterTextView.text = quantity.toString()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observeEvents() {
        viewModel._productsDetail.observe(viewLifecycleOwner) { product ->
            product?.let {
                Log.d("ProductDetailFragment", "Observed product: $product")
                binding.apply {
                    nameTextView.text = product.name
                    priceTextView.text = getString(R.string.fiyat) + product.price.toString()
                    informationTextView.text =
                        getString(R.string.urun_hakkinda) + product.information.toString()
                    scoreCountTextView.text =
                        getString(R.string.oy_veren_kisi_sayisi) + product.scoreCount.toString()
                    scoreTextView.text =
                        getString(R.string.puan) +
                        DecimalFormat("#.##")
                            .format(product.score)
                            .toString()
                    tradeMarkTextView.text = getString(R.string.markasi) + product.tradeMark
                    if (product.isStocksOut == true) {
                        isStocksOutTextView.text = getString(R.string.stok_var)
                    } else {
                        isStocksOutTextView.text = getString(R.string.stokta_kalmadi)
                    }
                }
            }
        }
    }

    private fun favouriteEvents(
        userId: String?,
        productId: Int?,
    ) {
        viewModel.getFavourite(userId)
        viewModel._products.observe(viewLifecycleOwner) {
            it?.forEach { ids ->
                if (ids?.id == productId) {
                    binding.favCheckBox.isChecked = true

                    binding.favCheckBox.setOnClickListener {
                        if (binding.favCheckBox.isChecked) {
                            viewModel.addFavourite(userId, productId)
                        } else {
                            viewModel.deleteFavourite(userId, productId)
                        }
                    }
                }
            }
        }
    }

    private fun addComment(productId: Int?) {
        viewModel.addScore(
            productId,
            binding.scoreEditText.text
                .toString()
                .toInt(),
            binding.commentEditText.text.toString(),
            userId,
        )
    }

    private fun getComments(productId: Int?) {
        lifecycleScope.launch {
            viewModel.getComments(productId, 6).collectLatest { pagingData ->
                commentsAdapter.submitData(pagingData)
            }
        }
    }
}
