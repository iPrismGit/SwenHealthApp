package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.DoctorItemBinding
import com.iprism.swenhealth.interfaces.OnAppointmentDoctorItemClickListener

class HospitalDoctorsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var listener: OnAppointmentDoctorItemClickListener

    fun setupListener(listener: OnAppointmentDoctorItemClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
       val binding = DoctorItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return HospitalDoctorsAdapter.HospitalDoctorItemViewHolder((binding))
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as HospitalDoctorItemViewHolder
        holder.binding.apply {
            bookAppointmentBtn.visibility = View.GONE
            onlineConsultBtn.visibility = View.VISIBLE
            hospitalVisitBtn.visibility = View.VISIBLE
            hospitalVisitBtn.setOnClickListener { p0 ->
                listener.onItemClicked(p1.toString())
            }
            onlineConsultBtn.setOnClickListener { p0 ->
                listener.onItemClicked(p1.toString())
            }

        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class HospitalDoctorItemViewHolder(var binding : DoctorItemBinding) : RecyclerView.ViewHolder(binding.root)

}