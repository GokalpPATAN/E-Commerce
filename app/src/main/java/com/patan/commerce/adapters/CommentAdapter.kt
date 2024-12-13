package com.patan.commerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.patan.commerce.databinding.ItemcommentrecyclerviewBinding
import com.patan.commerce.model.GetComment
import com.patan.commerce.utils.Constants

class CommentAdapter : PagingDataAdapter<GetComment, CommentAdapter.CommentViewHolder>(Constants.COMMENT_DIFF_CALLBACK) {
    class CommentViewHolder(
        val binding: ItemcommentrecyclerviewBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CommentViewHolder {
        val binding =
            ItemcommentrecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CommentViewHolder,
        position: Int,
    ) {
        val comment = getItem(position)
        holder.binding.apply {
            commentTextView.text = comment?.comment
        }
    }
}
