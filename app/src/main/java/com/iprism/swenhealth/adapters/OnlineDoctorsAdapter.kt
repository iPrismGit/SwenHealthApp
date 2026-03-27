package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.DoctorItemBinding
import com.iprism.swenhealth.interfaces.OnAppointmentDoctorItemClickListener

class OnlineDoctorsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onDoctorItemClickListener: OnAppointmentDoctorItemClickListener? = null

    fun setOnDoctorItemClickListener(onDoctorItemClickListener: OnAppointmentDoctorItemClickListener?) {
        this.onDoctorItemClickListener = onDoctorItemClickListener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = DoctorItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return OnLineDoctorViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as OnLineDoctorViewHolder
        holder.binding.apply {
            onlineConsultBtn.setOnClickListener { p0 ->
                onDoctorItemClickListener!!.onItemClicked(holder.position.toString())
             }
        }

    }

    override fun getItemCount(): Int {
        return 10
    }

    class  OnLineDoctorViewHolder(var binding : DoctorItemBinding) : RecyclerView.ViewHolder(binding.root)

}