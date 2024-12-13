package com.patan.commerce.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.patan.commerce.model.AddCartRequest
import com.patan.commerce.model.AddFavoriteRequest
import com.patan.commerce.model.AddScoreRequest
import com.patan.commerce.model.CartData
import com.patan.commerce.model.DeleteCardItemRequest
import com.patan.commerce.model.GetAddressRequest
import com.patan.commerce.model.GetCartRequest
import com.patan.commerce.model.GetComment
import com.patan.commerce.model.GetProductByIdRequest
import com.patan.commerce.model.HighestCategory
import com.patan.commerce.model.ParentIdRequest
import com.patan.commerce.model.Products
import com.patan.commerce.network.ApiService
import com.patan.commerce.utils.Constants
import com.patan.commerce.viewmodels.CategoriesPagingSource
import com.patan.commerce.viewmodels.ProductsPagingSource
import javax.inject.Inject

class ProductsRepository
    @Inject
    constructor(
        private val apiService: ApiService,
    ) {
        suspend fun getProducts(token: String?): List<Products>? {
            val response = apiService.getProducts(token)
            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception("Failed to fetch categories: ${response.message()}")
            }
        }

        fun getProductsByCategory(
            token: String?,
            categoryId: Int?,
            productCount: Int,
            options: Int,
        ): Pager<Int, Products> =
            Pager(
                config =
                    PagingConfig(
                        pageSize = productCount,
                        enablePlaceholders = false,
                        initialLoadSize = 6,
                    ),
                pagingSourceFactory = {
                    CategoriesPagingSource(apiService, token, categoryId, productCount, options)
                },
            )

        fun getComments(
            token: String?,
            productId: Int?,
            scoreCount: Int,
        ): Pager<Int, GetComment> =
            Pager(
                config = PagingConfig(pageSize = scoreCount, enablePlaceholders = true),
                pagingSourceFactory = {
                    ProductsPagingSource(
                        apiService,
                        token,
                        productId,
                        scoreCount,
                    )
                },
            )

        suspend fun getProductDetails(
            token: String?,
            productId: Int?,
            productScoreCount: Int?,
        ): Products? {
            val productRequest =
                GetProductByIdRequest(productId.toString(), productScoreCount.toString())
            val response = apiService.getProductDetails(token, productRequest)
            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception("Failed to fetch product details: ${response.message()}")
            }
        }

        suspend fun getCategories(token: String?): List<HighestCategory?>? {
            val response = apiService.getCategories(token)
            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception("Failed to fetch categories: ${response.message()}")
            }
        }

        suspend fun getTopCategories(
            token: String?,
            topCategoryId: Int?,
        ): List<HighestCategory?>? {
            val topCategoriesId = ParentIdRequest(topCategoryId)
            val response = apiService.getTopCategories(token, topCategoriesId)
            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception("Failed to fetch top categories: ${response.message()}")
            }
        }

        suspend fun addToCart(
            token: String?,
            cart: AddCartRequest,
        ) {
            apiService.addToCart(token, cart)
        }

        suspend fun getCart(
            token: String?,
            cart: GetCartRequest,
        ): CartData? {
            val response = apiService.getCart(token, cart)

            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception(Constants.ERROR)
            }
        }

        suspend fun deleteFromCart(
            token: String?,
            cart: DeleteCardItemRequest,
        ): CartData? {
            val response = apiService.deleteFromCart(token, cart)

            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception(Constants.ERROR)
            }
        }

        suspend fun clearCart(
            token: String?,
            cart: GetCartRequest,
        ): CartData? {
            val response = apiService.clearCart(token, cart)

            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception(Constants.ERROR)
            }
        }

        suspend fun addFavourite(
            token: String?,
            product: AddFavoriteRequest,
        ): CartData? {
            val response = apiService.addFavourite(token, product)

            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception(Constants.ERROR)
            }
        }

        suspend fun deleteFavourite(
            token: String?,
            product: AddFavoriteRequest,
        ): CartData? {
            val response = apiService.deleteFavourite(token, product)

            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception(Constants.ERROR)
            }
        }

        suspend fun getFavProducts(
            token: String?,
            request: GetAddressRequest,
        ): List<Products>? {
            val response = apiService.getFavourite(token, request)
            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception(Constants.ERROR)
            }
        }

        suspend fun addScore(
            token: String?,
            request: AddScoreRequest,
        ): CartData? {
            val response = apiService.addScore(token, request)
            if (response.isSuccessful) {
                return response.body()?.data
            } else {
                throw Exception(Constants.ERROR)
            }
        }
    }
