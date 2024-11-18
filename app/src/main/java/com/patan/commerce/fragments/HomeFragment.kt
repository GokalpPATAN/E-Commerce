//package com.patan.commerce.fragments
//
//import android.content.Context
//import android.os.Bundle
//import android.view.View
//import androidx.fragment.app.viewModels
//import androidx.navigation.NavController
//import androidx.navigation.fragment.findNavController
//import com.patan.commerce.R
//import com.patan.commerce.databinding.FragmentHomeBinding
//import com.patan.commerce.fragments.products.ProductsFragment
//import com.patan.commerce.fragments.user.BasketFragment
//import com.patan.commerce.fragments.user.FavouriteFragment
//import com.patan.commerce.fragments.user.UserFragment
//import com.patan.commerce.viewmodels.LoginViewModel
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
//    private lateinit var navController: NavController
//    private val viewModel by viewModels<LoginViewModel>()
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val pref = activity?.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE)
//        val token = pref?.getString("token", "default")
//        println(token)
//        navController = findNavController()
//        binding.apply {
//            bottomNav.setOnItemSelectedListener {
//                when (it.itemId) {
//                    R.id.productsFragment -> {
//                       replaceFragment(R.id.productsFragment)
//                        true
//                    }
//
//                    R.id.favouriteFragment -> {
//                        replaceFragment(R.id.favouriteFragment)
//                        true
//                    }
//
//                    R.id.basketFragment -> {
//                        replaceFragment(R.id.basketFragment)
//                        true
//                    }
//
//                    R.id.userFragment -> {
//                        replaceFragment(R.id.userFragment)
//                        true
//                    }
//
//                    else -> false
//
//                }
//
//            }
//        }
//    }
//    private fun replaceFragment(fragmentId: Int) {
//        val fragment = when (fragmentId) {
//            R.id.productsFragment -> ProductsFragment()
//            R.id.favouriteFragment -> FavouriteFragment()
//            R.id.basketFragment -> BasketFragment()
//            R.id.userFragment -> UserFragment()
//            else -> null
//        }
//
//        fragment?.let {
//            childFragmentManager.beginTransaction()
//                .replace(binding.fragmentContainerView4.id, it)
//                .commit()
//        }
//    }
//}