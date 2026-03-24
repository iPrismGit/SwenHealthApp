package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.HospitalItemBinding

class HospitalsAdapter () : RecyclerView.Adapter<RecyclerView.ViewHolder> () {

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = HospitalItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return HospitalViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as HospitalViewHolder
        holder.binding.apply {

        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class HospitalViewHolder(var binding: HospitalItemBinding) : RecyclerView.ViewHolder(binding.root)

}