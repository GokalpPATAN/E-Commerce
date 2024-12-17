package com.patan.commerce.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.patan.commerce.di.TokenQualifier
import com.patan.commerce.model.AddCartRequest
import com.patan.commerce.model.AddFavoriteRequest
import com.patan.commerce.model.AddScoreRequest
import com.patan.commerce.model.CartData
import com.patan.commerce.model.DeleteCardItemRequest
import com.patan.commerce.model.GetAddressRequest
import com.patan.commerce.model.GetCartRequest
import com.patan.commerce.model.HighestCategory
import com.patan.commerce.model.Products
import com.patan.commerce.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel
    @Inject
    constructor(
        private val repository: ProductsRepository,
        @TokenQualifier private val token: String?,
    ) : BaseViewModel() {
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

        fun getProducts() {
            viewModelScope.launch {
                try {
                    products.postValue(repository.getProducts(token))
                } catch (e: Exception) {
                    handleError(e.message)
                }
            }
        }

        fun getProductsByCategory(
            categoryId: Int,
            productCount: Int,
            options: Int,
        ) = repository.getProductsByCategory(token, categoryId, productCount, options).flow.cachedIn(
            viewModelScope,
        )

        fun getComments(
            productId: Int?,
            scoreCount: Int,
        ) = repository.getComments(token, productId, scoreCount).flow.cachedIn(viewModelScope)

        fun getProductDetails(
            productId: Int?,
            productScoreCount: Int?,
        ) {
            viewModelScope.launch {
                try {
                    productsDetail.postValue(
                        repository.getProductDetails(
                            token,
                            productId,
                            productScoreCount,
                        ),
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

        fun addToCart(
            userId: String?,
            productId: Int?,
            quantity: Int?,
        ) {
            viewModelScope.launch {
                val request = AddCartRequest(userId, productId, quantity)
                try {
                    repository.addToCart(token, request)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        fun getCart(userId: String?) {
            viewModelScope.launch {
                val basketRequest = GetCartRequest(userId)
                try {
                    basketList.postValue(repository.getCart(token, basketRequest))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        fun deleteFromCart(prodId: Int?) {
            viewModelScope.launch {
                val request = DeleteCardItemRequest(prodId)
                try {
                    repository.deleteFromCart(token, request)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        fun clearCart(userId: String?) {
            viewModelScope.launch {
                val request = GetCartRequest(userId)
                try {
                    repository.clearCart(token, request)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        fun addFavourite(
            userId: String?,
            productId: Int?,
        ) {
            viewModelScope.launch {
                val request = AddFavoriteRequest(userId, productId)
                try {
                    repository.addFavourite(token, request)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        fun deleteFavourite(
            userId: String?,
            productId: Int?,
        ) {
            viewModelScope.launch {
                val request = AddFavoriteRequest(userId, productId)
                try {
                    repository.deleteFavourite(token, request)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        fun getFavourite(userId: String?) {
            viewModelScope.launch {
                val request = GetAddressRequest(userId)
                try {
                    products.postValue(repository.getFavProducts(token, request))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        fun addScore(
            productId: Int?,
            score: Int?,
            comment: String?,
            userId: String?,
        ) {
            viewModelScope.launch {
                val request = AddScoreRequest(productId, score, comment, userId)
                try {
                    repository.addScore(token, request)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
