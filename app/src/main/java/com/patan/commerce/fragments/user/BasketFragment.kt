package com.patan.commerce.fragments.user

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.patan.commerce.R
import com.patan.commerce.adapters.BasketAdapter
import com.patan.commerce.adapters.BasketClickListener
import com.patan.commerce.databinding.FragmentBasketBinding
import com.patan.commerce.di.UserIdQualifier
import com.patan.commerce.fragments.BaseFragment
import com.patan.commerce.model.ItemList
import com.patan.commerce.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BasketFragment : BaseFragment<FragmentBasketBinding>(FragmentBasketBinding::inflate) {
    private val viewModel by viewModels<ProductsViewModel>()
    private lateinit var basketAdapter: BasketAdapter

    @UserIdQualifier
    @Inject
    lateinit var userId: String

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCart(userId)
        viewModel._basketList.observe(viewLifecycleOwner) {
            if (it != null) {
                basketAdapter =
                    BasketAdapter(
                        it,
                        object : BasketClickListener {
                            override fun onBasketClicked(productId: Int?) {
                                viewModel.deleteFromCart(productId)
                            }
                        },
                    )
                binding.recyclerViewBasket.adapter = basketAdapter
                binding.totalPriceTextView.text =
                    getString(R.string.total_price_of_basket) +
                    basketAdapter
                        .calculateTotalBasketPrice()
                        .toString() +
                    getString(
                        R.string.turk_lirasi_sembol,
                    )
                binding.checkoutButton.setOnClickListener {
                    val cartItems = ItemList(basketAdapter.findItems())
                    val action = BasketFragmentDirections.actionBasketFragment2ToOrderFragment(cartItems)
                    findNavController().navigate(action)
                }
            } else {
                Toast
                    .makeText(
                        this.requireContext(),
                        "There is no product in Cart",
                        Toast.LENGTH_LONG,
                    ).show()
            }
        }
        binding.deleteCart.setOnClickListener { viewModel.clearCart(userId) }
    }
}
