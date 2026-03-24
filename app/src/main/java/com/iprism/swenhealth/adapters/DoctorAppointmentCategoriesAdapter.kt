package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.ServiceItemBinding
import com.iprism.swenhealth.interfaces.OnServiceItemClickListener

class DoctorAppointmentCategoriesAdapter () : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private lateinit var listener: OnServiceItemClickListener

    fun setupListener(listener: OnServiceItemClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
       val binding = ServiceItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return DoctorAppointmentCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as DoctorAppointmentCategoryViewHolder

        holder.binding.root.setOnClickListener { p0 ->
            listener.onItemClick(holder.position)
        }

    }

    override fun getItemCount(): Int {
        return 9
    }

    class DoctorAppointmentCategoryViewHolder(var binding: ServiceItemBinding) : RecyclerView.ViewHolder(binding.root)
}