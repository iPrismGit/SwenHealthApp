package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.HospitalItemBinding
import com.iprism.swenhealth.interfaces.OnHospitalClickListener

class DiagnosticsAndLabsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var listener: OnHospitalClickListener

    fun setupListener(listener: OnHospitalClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = HospitalItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return DiagnosticItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as DiagnosticItemViewHolder
        holder.binding.nameTxt.text = "Vijaya Diagnostic Center"
        holder.binding.timingTxt.text = "NABL, ISO"
        holder.binding.root.setOnClickListener { view ->
            listener.onItemClick(holder.position)
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class DiagnosticItemViewHolder(var binding: HospitalItemBinding) : RecyclerView.ViewHolder(binding.root)
}