package com.patan.commerce.adapters

import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder>(
    protected val items: List<T?>?,
    protected val clickListener: Any,
) : RecyclerView.Adapter<VH>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): VH {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: VH,
        position: Int,
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = items?.size ?: 0

    protected fun getItem(position: Int): T? = items?.getOrNull(position)

    protected fun bindTextandEditView(
        textView: TextView,
        editText: EditText,
        value: String?,
    ) {
        textView.text = value
        editText.setText(value)
    }

    protected fun bindTextView(
        textView: TextView,
        value: String?,
    ) {
        textView.text = value
    }

    protected fun bindAddressTextVisible(
        textView: TextView,
        editText: EditText,
        visible: Boolean,
    ) {
        textView.isVisible = visible
        editText.isVisible = !visible
    }

    protected fun bindAutoComplete(
        textView: TextView,
        editText: EditText,
        addressValue: String?,
    ): String? {
        val text = editText.text.toString()
        textView.text = text
        return if (text.isBlank()) {
            editText.setText(addressValue)
            addressValue
        } else {
            text
        }
    }
}
