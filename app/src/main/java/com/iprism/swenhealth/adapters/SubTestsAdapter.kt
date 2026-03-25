package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.iprism.swenhealth.databinding.SubTestItemBinding

class SubTestsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = SubTestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubTestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }

    class SubTestViewHolder(binding: SubTestItemBinding) : RecyclerView.ViewHolder(binding.root)

}
