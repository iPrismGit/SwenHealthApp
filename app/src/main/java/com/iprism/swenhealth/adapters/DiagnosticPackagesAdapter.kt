package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.DiagnosticPackageItemBinding

class DiagnosticPackagesAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = DiagnosticPackageItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return DiagnosticPackageViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as DiagnosticPackageViewHolder


    }

    override fun getItemCount(): Int {
        return 10
    }

    class DiagnosticPackageViewHolder(var binding: DiagnosticPackageItemBinding) : RecyclerView.ViewHolder(binding.root)

}