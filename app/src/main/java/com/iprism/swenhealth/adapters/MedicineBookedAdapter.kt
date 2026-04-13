package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.MedicineBookedItemBinding

class MedicineBookedAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = MedicineBookedItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return MedicineBookedViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as MedicineBookedViewHolder
        holder.binding.apply {

        }

    }

    override fun getItemCount(): Int {
        return 2
    }

    class MedicineBookedViewHolder(val binding: MedicineBookedItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}