package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.iprism.swenhealth.databinding.PharmacyProductItemBinding

class MedicineProductsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = PharmacyProductItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return MedicineProductViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
       val holder = p0 as MedicineProductViewHolder
        holder.binding.apply {

        }
    }

    override fun getItemCount(): Int {
        return 12
    }

    class MedicineProductViewHolder(var binding: PharmacyProductItemBinding) : RecyclerView.ViewHolder(binding.root)

}