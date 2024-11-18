package com.patan.commerce.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.patan.commerce.di.TokenQualifier
import com.patan.commerce.model.AddCartRequest
import com.patan.commerce.model.CartData
import com.patan.commerce.model.GetCartRequest
import com.patan.commerce.model.HighestCategory
import com.patan.commerce.model.Products
import com.patan.commerce.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repository: ProductsRepository,
    @TokenQualifier private val token: String?
) :
    BaseViewModel() {

    private val products: MutableLiveData<List<Products?>?> = MutableLiveData()
    val _products get() = products

    private val productsDetail: MutableLiveData<Products?> = MutableLiveData()
    val _productsDetail get() = productsDetail

    private val categoriesList: MutableLiveData<List<HighestCategory?>?> = MutableLiveData()
    val _categoriesList get() = categoriesList

    private val topCategoriesList: MutableLiveData<List<HighestCategory?>?> = MutableLiveData()
    val _topCategoriesList get() = topCategoriesList

    private val basketList: MutableLiveData<CartData> = MutableLiveData()
    val _basketList get() = basketList



    fun getProducts() =
        repository.getProducts(token).flow.cachedIn(
            viewModelScope
        )


    fun getProductsByCategory(categoryId: Int, productCount: Int, options: Int) =
        repository.getProductsByCategory(token, categoryId, productCount, options).flow.cachedIn(
            viewModelScope
        )

    fun getProductDetails(productId: Int?, productScoreCount: Int?) {
        viewModelScope.launch {
            try {
                productsDetail.postValue(
                    repository.getProductDetails(
                        token,
                        productId,
                        productScoreCount
                    )
                )
            } catch (e: Exception) {
                handleError(e.message)
            }
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            try {
                categoriesList.postValue(repository.getCategories(token))
            } catch (e: Exception) {
                handleError(e.message)
            }
        }
    }

    fun getTopCategories(topCategoryId: Int?) {
        viewModelScope.launch {
            try {
                topCategoriesList.postValue(repository.getTopCategories(token, topCategoryId))
            } catch (e: Exception) {
                handleError(e.message)
            }
        }
    }

    fun addToCart(userId: String?, productId: Int?, quantity: Int?) {
        viewModelScope.launch {
            val request = AddCartRequest(userId, productId, quantity)
            try {
                repository.AddToCart(token, request)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    fun getCart(userId: String?) {
        viewModelScope.launch {
            val basketRequest = GetCartRequest(userId)
            try {
                basketList.postValue(repository.GetCart(token, basketRequest))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}
