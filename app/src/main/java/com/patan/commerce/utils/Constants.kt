package com.patan.commerce.utils

import androidx.recyclerview.widget.DiffUtil
import com.patan.commerce.model.GetComment

class Constants {
    companion object {
        const val BASE_URL = "https://compras.com.tr/api/"

        const val ERROR = "Failed to fetch"

        val COMMENT_DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<GetComment>() {
                override fun areItemsTheSame(
                    oldItem: GetComment,
                    newItem: GetComment,
                ): Boolean = oldItem.productId == newItem.productId // Use a unique identifier

                override fun areContentsTheSame(
                    oldItem: GetComment,
                    newItem: GetComment,
                ): Boolean = oldItem == newItem
            }
    }
}
