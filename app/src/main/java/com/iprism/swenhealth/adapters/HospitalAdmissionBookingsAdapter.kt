package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.HospitalAdmissionBookingItemBinding
import com.iprism.swenhealth.interfaces.OnHospitalAdmitBookingItemClickListener

class HospitalAdmissionBookingsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listener: OnHospitalAdmitBookingItemClickListener? = null

    fun setupListener(listener: OnHospitalAdmitBookingItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = HospitalAdmissionBookingItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return HospitalAdmissionBookingViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as HospitalAdmissionBookingViewHolder
        holder.binding.apply {
            root.setOnClickListener { p0 ->
                listener!!.onItemClicked("", "")
            }
        }
    }

    override fun getItemCount(): Int {
       return 5
    }

    class HospitalAdmissionBookingViewHolder(val binding: HospitalAdmissionBookingItemBinding) : RecyclerView.ViewHolder(binding.root)

}