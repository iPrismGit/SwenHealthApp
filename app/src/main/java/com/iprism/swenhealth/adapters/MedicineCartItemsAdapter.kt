package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.PharmacyCartItemBinding

class MedicineCartItemsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = PharmacyCartItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return MedicineCartItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
       val holder = p0 as MedicineCartItemViewHolder
        holder.binding.apply {

        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    class MedicineCartItemViewHolder(var binding: PharmacyCartItemBinding) : RecyclerView.ViewHolder(binding.root)

}