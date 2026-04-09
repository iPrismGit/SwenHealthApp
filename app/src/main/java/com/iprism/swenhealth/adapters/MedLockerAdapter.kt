package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.MedLockerItemBinding
import com.iprism.swenhealth.interfaces.OnDocumentItemClickListener

class MedLockerAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onDocumentItemClickListener: OnDocumentItemClickListener? = null

    fun setOnDocumentItemClickListener(onDocumentItemClickListener: OnDocumentItemClickListener?) {
        this.onDocumentItemClickListener = onDocumentItemClickListener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = MedLockerItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return MedLockerItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as MedLockerItemViewHolder
        holder.binding.apply {
           nameTxt.text = "Medical Document"
            root.setOnClickListener(View.OnClickListener {
                onDocumentItemClickListener!!.onItemClicked(p0.toString())
            })
        }

    }

    override fun getItemCount(): Int {
      return 4
    }

    class MedLockerItemViewHolder(var binding: MedLockerItemBinding) : RecyclerView.ViewHolder(binding.root)

}