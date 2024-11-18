package com.patan.commerce

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.patan.commerce.databinding.ActivityMain2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        createBottomNavigation()
        enableEdgeToEdge()

        binding.apply {
            bottomNav.setOnItemSelectedListener { item ->

                when (item.itemId) {
                    R.id.productsFragment -> {
                        navController.navigate(R.id.productsFragment)
                        true
                    }

                    R.id.basketFragment -> {
                        navController.navigate(R.id.basketFragment2)
                        true
                    }

                    R.id.userFragment -> {
                        navController.navigate(R.id.userFragment)
                        true
                    }

                    R.id.favouriteFragment -> {
                        navController.navigate(R.id.favouriteFragment2)
                        true
                    }

                    else -> false
                }
            }
        }
    }

    private fun createBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView4) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNav, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}