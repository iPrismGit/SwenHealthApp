package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.ServiceItemBinding

class OnlineDoctorCategoriesAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = ServiceItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return OnlineDoctorCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as OnlineDoctorCategoryViewHolder
        holder.binding.apply {
            categoryName.text = "General \n" +
                    "Physician"
        }

    }

    override fun getItemCount(): Int {
        return 14
    }

    class OnlineDoctorCategoryViewHolder(var binding: ServiceItemBinding) : RecyclerView.ViewHolder(binding.root)
}