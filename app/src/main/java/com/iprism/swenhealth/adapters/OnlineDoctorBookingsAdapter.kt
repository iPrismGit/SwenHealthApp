package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.OnlineDoctorBookingItemBinding
import com.iprism.swenhealth.interfaces.OnOnlineDoctorBookingItemClickListener

class OnlineDoctorBookingsAdapter()  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listener: OnOnlineDoctorBookingItemClickListener? = null

    fun setupListener(listener: OnOnlineDoctorBookingItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = OnlineDoctorBookingItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return OnlineDoctorBookingViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as OnlineDoctorBookingViewHolder
        holder.binding.apply {
            root.setOnClickListener { p0 ->
                listener!!.onItemClicked(p1.toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return 5
    }

    class OnlineDoctorBookingViewHolder(var binding: OnlineDoctorBookingItemBinding) : RecyclerView.ViewHolder(binding.root)

}