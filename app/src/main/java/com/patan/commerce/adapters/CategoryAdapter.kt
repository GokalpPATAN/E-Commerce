package com.patan.commerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patan.commerce.databinding.ItemcategoryrecyclerviewBinding
import com.patan.commerce.model.HighestCategory

class CategoryAdapter(
    private val categoryList: List<HighestCategory?>?,
    private val categoryClickListener: CategoryClickListener,
) : BaseAdapter<HighestCategory, CategoryAdapter.ViewHolder>(categoryList, categoryClickListener) {
    class ViewHolder(
        val binding: ItemcategoryrecyclerviewBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder =
        ViewHolder(
            ItemcategoryrecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun getItemCount(): Int = categoryList!!.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        val category = categoryList!![position]

        holder.binding.categoryNameTextView.text = category?.name

        holder.binding.root.setOnClickListener {
            if (category?.topCategoryId != null) {
                categoryClickListener.onCategoryClicked(category.topCategoryId)
            } else {
                categoryClickListener.onCategoryClicked(category?.categoryId)
            }
        }
    }
}
