package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.HealthMediaItemBinding

class HealthMediaAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = HealthMediaItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return HealthMediaViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as HealthMediaViewHolder
        holder.binding.apply {

        }
    }

    override fun getItemCount(): Int {
       return 10
    }

    class HealthMediaViewHolder(val binding: HealthMediaItemBinding) : RecyclerView.ViewHolder(binding.root)
}