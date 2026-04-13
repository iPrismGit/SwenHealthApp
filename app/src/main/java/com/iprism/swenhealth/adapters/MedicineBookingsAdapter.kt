package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.HospitalMedicineBookingItemBinding
import com.iprism.swenhealth.interfaces.OnBookingItemClickListener

class MedicineBookingsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listener: OnBookingItemClickListener? = null

    fun setupListener(listener: OnBookingItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = HospitalMedicineBookingItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return MedicineBookingViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as MedicineBookingViewHolder
        holder.binding.apply {
            root.setOnClickListener { p0 ->
                listener!!.onItemClicked(p1.toString(), "")
            }
        }
    }

    override fun getItemCount(): Int {
        return 5
    }
    class MedicineBookingViewHolder(val binding: HospitalMedicineBookingItemBinding) : RecyclerView.ViewHolder(binding.root)

}