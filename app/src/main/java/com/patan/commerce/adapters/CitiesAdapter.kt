package com.patan.commerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patan.commerce.databinding.ItemcitiesrecyclerviewBinding
import com.patan.commerce.model.Cities

class CitiesAdapter(
    private val citiesList: List<Cities?>?,
    private val citiesClickListener: CitiesClickListener
) : RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemcitiesrecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemcitiesrecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return citiesList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = citiesList!![position]

        holder.binding.cityNameTextView.text = city?.name

        holder.binding.root.setOnClickListener {
            citiesClickListener.onCitiesClicked(
                city?.Id,
                city?.name
            )
        }
    }

}

