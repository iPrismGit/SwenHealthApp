package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.HospitalItemBinding
import com.iprism.swenhealth.interfaces.OnHomeCareServiceHospitalClickListener

class HomeCareHospitalsAdapter() : RecyclerView.Adapter <RecyclerView.ViewHolder>(){

    private lateinit var listener: OnHomeCareServiceHospitalClickListener

    fun setupListener(listener: OnHomeCareServiceHospitalClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = HospitalItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return HomeCareHospitalViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as HomeCareHospitalViewHolder
        holder.binding.apply {
            root.setOnClickListener { p0 ->
                listener.onItemClick(p1.toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class HomeCareHospitalViewHolder(val binding: HospitalItemBinding) : RecyclerView.ViewHolder(binding.root)

}