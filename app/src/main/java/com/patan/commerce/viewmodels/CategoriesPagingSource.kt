package com.patan.commerce.viewmodels

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.patan.commerce.model.Products
import com.patan.commerce.model.ProductsByCategoryRequest
import com.patan.commerce.network.ApiService

class CategoriesPagingSource(
    private val apiService: ApiService,
    private val token: String?,
    private val categoryId: Int?,
    private val productCount: Int?,
    private val options: Int?,
) : PagingSource<Int, Products>() {
    override fun getRefreshKey(state: PagingState<Int, Products>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state
                .closestPageToPosition(
                    anchorPosition,
                )?.prevKey
                ?.plus(1) ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Products> {
        val pageNumber = params.key ?: 1
        return try {
            val response =
                apiService.getProductsByCategory(
                    token,
                    ProductsByCategoryRequest(categoryId, pageNumber, productCount, options),
                )
            if (response.isSuccessful) {
                val products = response.body()?.data ?: emptyList()
                LoadResult.Page(
                    data = products,
                    prevKey = if (pageNumber == 1) null else pageNumber - 1,
                    nextKey = if (products.isEmpty()) null else pageNumber + 1,
                )
            } else {
                LoadResult.Error(Exception("API Error: ${response.message()}"))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
