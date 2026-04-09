package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.HospitalItemBinding
import com.iprism.swenhealth.interfaces.OnHospitalClickListener

class OfferHospitalsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var listener: OnHospitalClickListener

    fun setupListener(listener: OnHospitalClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = HospitalItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return OfferHospitalViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as OfferHospitalViewHolder
        holder.binding.apply {
            offerTxt.visibility = View.VISIBLE
            root.setOnClickListener { p0 ->
                listener.onItemClick(p1)
            }
        }
    }

    override fun getItemCount(): Int {
       return 10
    }

    class OfferHospitalViewHolder(val binding: HospitalItemBinding) : RecyclerView.ViewHolder(binding.root)
}