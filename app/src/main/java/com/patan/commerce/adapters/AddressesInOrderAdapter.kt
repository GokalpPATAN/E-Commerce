package com.patan.commerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.patan.commerce.databinding.ItemaddressesinorderrecyclerviewBinding
import com.patan.commerce.model.Addresses

class AddressesInOrderAdapter(
    private val addressList: List<Addresses?>?,
    private val addressClickListener: AddressClickListener,
) : BaseAdapter<Addresses, AddressesInOrderAdapter.ViewHolder>(addressList, addressClickListener) {
    private val _selectedAddressId = MutableLiveData<String?>()
    val selectedAddressId: MutableLiveData<String?> = _selectedAddressId

    class ViewHolder(
        val binding: ItemaddressesinorderrecyclerviewBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder =
        ViewHolder(
            ItemaddressesinorderrecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun getItemCount(): Int = addressList!!.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        val address = addressList!![position]
        bindTextView(holder.binding.textCityName, address?.addressName)
        bindTextView(holder.binding.textDescription, address?.description)
        bindTextView(holder.binding.textCountyName, address?.cityName)
        holder.binding.root.setOnClickListener {
            val isChecked = holder.binding.checkBox.isChecked
            holder.binding.checkBox.isChecked = !isChecked
            if (!isChecked) {
                addressClickListener.onAddressClicked(address?.id)
            } else {
                _selectedAddressId.value = null
            }
        }
    }
}
