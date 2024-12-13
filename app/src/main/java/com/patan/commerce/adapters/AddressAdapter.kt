package com.patan.commerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.patan.commerce.databinding.ItemaddressrecyclerviewBinding
import com.patan.commerce.model.Addresses

class AddressAdapter(
    private val addressList: List<Addresses?>?,
    private val addressClickListener: AddressClickListener,
) : BaseAdapter<Addresses, AddressAdapter.ViewHolder>(addressList, addressClickListener) {
    class ViewHolder(
        val binding: ItemaddressrecyclerviewBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder =
        ViewHolder(
            ItemaddressrecyclerviewBinding.inflate(
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
        holder.binding.imageView4.setOnClickListener {
            addressClickListener.onAddressUpdated(
                address?.id,
                bindAutoComplete(
                    holder.binding.textCityName,
                    holder.binding.editCityName,
                    address?.cityName,
                ),
                bindAutoComplete(
                    holder.binding.textCountyName,
                    holder.binding.editCountyName,
                    address?.countyName,
                ),
                bindAutoComplete(
                    holder.binding.textDescription,
                    holder.binding.editDescription,
                    address?.description,
                ),
                bindAutoComplete(
                    holder.binding.textAddressName,
                    holder.binding.editAddressName,
                    address?.addressName,
                ),
                bindAutoComplete(
                    holder.binding.textReceiverName,
                    holder.binding.editReceiverName,
                    address?.receiverName,
                ),
                bindAutoComplete(
                    holder.binding.textReceiverPhone,
                    holder.binding.editReceiverPhone,
                    address?.receiverPhone,
                ),
            )
            holder.apply {
                binding.apply {
                    bindAddressTextVisible(textDescription, editDescription, true)
                    bindAddressTextVisible(textAddressName, editAddressName, true)
                    bindAddressTextVisible(textCityName, editCityName, true)
                    bindAddressTextVisible(textCountyName, editCountyName, true)
                    bindAddressTextVisible(textReceiverPhone, editReceiverPhone, true)
                    bindAddressTextVisible(textReceiverName, editReceiverName, true)
                }
            }
        }

        bindTextandEditView(
            holder.binding.textAddressName,
            holder.binding.editAddressName,
            address?.addressName,
        )
        bindTextandEditView(
            holder.binding.textDescription,
            holder.binding.editDescription,
            address?.description,
        )
        bindTextandEditView(
            holder.binding.textCityName,
            holder.binding.editCityName,
            address?.cityName,
        )
        bindTextandEditView(
            holder.binding.textCountyName,
            holder.binding.editCountyName,
            address?.countyName,
        )
        bindTextandEditView(
            holder.binding.textReceiverPhone,
            holder.binding.editReceiverPhone,
            address?.receiverPhone,
        )
        bindTextandEditView(
            holder.binding.textReceiverName,
            holder.binding.editReceiverName,
            address?.receiverName,
        )
        holder.apply {
            binding.textDescription.setOnClickListener {
                bindAddressTextVisible(it as TextView, holder.binding.editDescription, false)
            }
            binding.textAddressName.setOnClickListener {
                bindAddressTextVisible(it as TextView, holder.binding.editAddressName, false)
            }
            binding.textCityName.setOnClickListener {
                bindAddressTextVisible(it as TextView, holder.binding.editCityName, false)
            }
            binding.editCountyName.setOnClickListener {
                bindAddressTextVisible(it as TextView, holder.binding.editCountyName, false)
            }
            binding.textReceiverPhone.setOnClickListener {
                bindAddressTextVisible(it as TextView, holder.binding.editReceiverPhone, false)
            }
            binding.textReceiverName.setOnClickListener {
                bindAddressTextVisible(it as TextView, holder.binding.editReceiverName, false)
            }
        }

        holder.binding.deleteButton.setOnClickListener {
            addressClickListener.onAddressClicked(address?.id)
        }
    }
}
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val address = addressList!![position]
//
//        holder.apply {
//            binding.textAddressName.text = address?.addressName
//            binding.textDescription.text = address?.description
//            binding.textCityName.text = address?.cityName
//            binding.textCountyName.text = address?.countyName
//            binding.textReceiverPhone.text = address?.receiverPhone
//            binding.textReceiverName.text = address?.receiverName
//
//            binding.editAddressName.setText(address?.addressName)
//            binding.editDescription.setText(address?.description)
//            binding.editCityName.setText(address?.cityName)
//            binding.editCountyName.setText(address?.countyName)
//            binding.editReceiverPhone.setText(address?.receiverPhone)
//            binding.editReceiverName.setText(address?.receiverName)
//
//
//        }
//        holder.binding.root.setOnClickListener {
//            addressClickListener.onAddressClicked(address?.id)
//        }
//
//        holder.binding.deleteButton.setOnClickListener {
//            addressClickListener.onAddressClicked(address?.id)
//        }
//
//        holder.apply {
//            binding.textDescription.setOnClickListener {
//                it.isVisible = false
//                binding.editDescription.isVisible = true
//            }
//            binding.textAddressName.setOnClickListener {
//                it.isVisible = false
//                binding.editAddressName.isVisible = true
//            }
//            binding.textCityName.setOnClickListener {
//                it.isVisible = false
//                binding.editCityName.isVisible = true
//            }
//            binding.editCountyName.setOnClickListener {
//                it.isVisible = false
//                binding.editCountyName.isVisible = true
//            }
//            binding.textReceiverPhone.setOnClickListener {
//                it.isVisible = false
//                binding.editReceiverPhone.isVisible = true
//            }
//            binding.textReceiverName.setOnClickListener {
//                it.isVisible = false
//                binding.editReceiverName.isVisible = true
//            }
//        }
//        holder.binding.imageView4.setOnClickListener {
//            addressClickListener.onAddressUpdated(address?.id,
//                holder.binding.editCityName.text.toString().takeIf { it.isNotBlank() }
//                    ?: address?.cityName,
//                holder.binding.editCountyName.text.toString().takeIf { it.isNotBlank() }
//                    ?: address?.countyName,
//                holder.binding.editDescription.text.toString().takeIf { it.isNotBlank() }
//                    ?: address?.description,
//                holder.binding.editAddressName.text.toString().takeIf { it.isNotBlank() }
//                    ?: address?.addressName,
//                holder.binding.editReceiverName.text.toString().takeIf { it.isNotBlank() }
//                    ?: address?.receiverName,
//                holder.binding.editReceiverPhone.text.toString().takeIf { it.isNotBlank() }
//                    ?: address?.receiverPhone)
//            holder.apply {
//                binding.apply {
//                    textDescription.isVisible = true
//                    editDescription.isVisible = false
//
//                    textAddressName.isVisible = true
//                    editAddressName.isVisible = false
//
//                    textCityName.isVisible = true
//                    editCityName.isVisible = false
//
//                    editCountyName.isVisible = true
//                    editCountyName.isVisible = false
//
//                    textReceiverPhone.isVisible = true
//                    editReceiverPhone.isVisible = false
//
//                    textReceiverName.isVisible = true
//                    editReceiverName.isVisible = false
//                }
//            }
//        }
//    }
//
// }
