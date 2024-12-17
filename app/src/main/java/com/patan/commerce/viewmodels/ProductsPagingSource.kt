package com.patan.commerce.viewmodels

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.patan.commerce.model.GetComment
import com.patan.commerce.model.GetCommentRequest
import com.patan.commerce.network.ApiService

class ProductsPagingSource(
    private val apiService: ApiService,
    private val token: String?,
    private val productId: Int?,
    private val scoreCount: Int?,
) : PagingSource<Int, GetComment>() {
    override fun getRefreshKey(state: PagingState<Int, GetComment>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state
                .closestPageToPosition(
                    anchorPosition,
                )?.prevKey
                ?.plus(1) ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GetComment> {
        val pageNumber = params.key ?: 1

        return try {
            val request = GetCommentRequest(productId, pageNumber, scoreCount)
            val response = apiService.getScore(token, request)

            if (response.isSuccessful) {
                val products = response.body()?.data ?: emptyList()

                val isEndOfList = products.size < params.loadSize

                LoadResult.Page(
                    data = products,
                    prevKey = if (pageNumber == 1) null else pageNumber - 1,
                    nextKey = if (isEndOfList) null else pageNumber + 1,
                )
            } else {
                LoadResult.Error(Exception("API Error: ${response.message()}"))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
