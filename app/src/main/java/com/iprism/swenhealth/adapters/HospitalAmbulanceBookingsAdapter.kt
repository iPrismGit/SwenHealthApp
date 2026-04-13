package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.HospitalAmbulanceBookingItemBinding
import com.iprism.swenhealth.interfaces.OnAmbulanceBookingItemClickListener

class HospitalAmbulanceBookingsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listener: OnAmbulanceBookingItemClickListener? = null

    fun setupListener(listener: OnAmbulanceBookingItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = HospitalAmbulanceBookingItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return HospitalAmbulanceBookingViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as HospitalAmbulanceBookingViewHolder
        holder.binding.apply {
            root.setOnClickListener { p0 ->
                listener!!.onItemClicked("")
            }
        }
    }

    override fun getItemCount(): Int {
        return 1
    }

    class HospitalAmbulanceBookingViewHolder(val binding : HospitalAmbulanceBookingItemBinding) : RecyclerView.ViewHolder(binding.root)
}