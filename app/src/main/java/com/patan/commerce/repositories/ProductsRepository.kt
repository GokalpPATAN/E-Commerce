package com.patan.commerce.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.patan.commerce.model.AddCartRequest
import com.patan.commerce.model.CartData
import com.patan.commerce.model.GetCartRequest
import com.patan.commerce.model.GetProductByIdRequest
import com.patan.commerce.model.HighestCategory
import com.patan.commerce.model.ParentIdRequest
import com.patan.commerce.model.Products
import com.patan.commerce.network.ApiService
import com.patan.commerce.viewmodels.CategoriesPagingSource
import com.patan.commerce.viewmodels.ProductsPagingSource
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val apiService: ApiService) {


    fun getProducts(token: String?): Pager<Int, Products> {
        return Pager(config = PagingConfig(pageSize = 6, enablePlaceholders = false),
            pagingSourceFactory = { ProductsPagingSource(apiService, token) })
    }

    fun getProductsByCategory(
        token: String?, categoryId: Int?, productCount: Int, options: Int
    ): Pager<Int, Products> {
        return Pager(config = PagingConfig(
            pageSize = productCount, enablePlaceholders = false, initialLoadSize = 6
        ), pagingSourceFactory = {
            CategoriesPagingSource(apiService, token, categoryId, productCount, options)
        })
    }

    suspend fun getProductDetails(
        token: String?, productId: Int?, productScoreCount: Int?
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
        token: String?, topCategoryId: Int?
    ): List<HighestCategory?>? {
        val topCategoriesId = ParentIdRequest(topCategoryId)
        val response = apiService.getTopCategories(token, topCategoriesId)
        if (response.isSuccessful) {
            return response.body()?.data
        } else {
            throw Exception("Failed to fetch top categories: ${response.message()}")
        }
    }

    suspend fun AddToCart(token: String?, cart: AddCartRequest) {
        apiService.addToCart(token, cart)
    }

    suspend fun GetCart(token: String?, cart:GetCartRequest): CartData? {
        val response = apiService.GetCart(token, cart)

        if (response.isSuccessful) {
        return response.body()?.data
        } else {
            throw Exception("Failed to fetch")
        }
    }

}
