package com.iprism.swenhealth.adapters
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.FamilyMemberItemBinding
import com.iprism.swenhealth.interfaces.OnMultipleFamilyItemClickListener


class MultiFamilyMembersAdapter  : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var onMultipleFamilyItemClickListener: OnMultipleFamilyItemClickListener? = null

    fun setOnMultipleFamilyItemClickListener(onMultipleFamilyItemClickListener: OnMultipleFamilyItemClickListener?) {
        this.onMultipleFamilyItemClickListener = onMultipleFamilyItemClickListener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = FamilyMemberItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return FamilyMemberViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as FamilyMemberViewHolder
        holder.binding.apply {
            holder.binding.root.setOnClickListener {
                onMultipleFamilyItemClickListener?.onItemClicked(p1.toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return 5
    }

    class FamilyMemberViewHolder(var binding: FamilyMemberItemBinding) : RecyclerView.ViewHolder(binding.root)
}