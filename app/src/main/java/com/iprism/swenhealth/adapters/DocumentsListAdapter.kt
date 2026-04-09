package com.iprism.swenhealth.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iprism.swenhealth.databinding.DocumentItemBinding
import com.iprism.swenhealth.databinding.MedLockerItemBinding

class DocumentsListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = DocumentItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return DocumentViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as DocumentViewHolder
        holder.binding.apply {

        }
    }

    override fun getItemCount(): Int {
        return 5
    }

    class DocumentViewHolder(val binding: DocumentItemBinding) : RecyclerView.ViewHolder(binding.root)

}
