package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.DiagnosticTestBookingItemBinding
import com.iprism.swenhealth.interfaces.OnBookingItemClickListener

class DiagnosticTestBookingsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listener: OnBookingItemClickListener? = null

    fun setOnBookingItemClickListener(listener: OnBookingItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding =
            DiagnosticTestBookingItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return DiagnosticTestBookingViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as DiagnosticTestBookingViewHolder
        holder.binding.apply {
            root.setOnClickListener { p0 ->
                listener!!.onItemClicked(p1.toString(), "Booking")
            }

        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class DiagnosticTestBookingViewHolder(val binding: DiagnosticTestBookingItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}