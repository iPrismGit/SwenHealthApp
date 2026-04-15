package com.iprism.swenhealth.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.FilterCatItemBinding
import com.iprism.swenhealth.interfaces.OnFilterCatItemClickListener

class FilterCatsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var selectedItem = 0

    private var listener: OnFilterCatItemClickListener? = null

    fun setListener(listener: OnFilterCatItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = FilterCatItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return FilterCatViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        @SuppressLint("RecyclerView") p1: Int
    ) {
       val holder = p0 as FilterCatViewHolder
        holder.binding.apply {
            if (p1 == 1){
                holder.binding.catTxt.text = "Hospital Category"
            } else if
                           (p1 == 2){
                holder.binding.catTxt.text = "Speciality"
            } else{
                holder.binding.catTxt.text = "Online Consultation"
            }
            if (selectedItem == p1) {
                catTxt.setBackgroundColor(Color.parseColor("#FDE4C7"))
            } else {
                catTxt.setBackgroundColor(Color.parseColor("#FFFFFF"))
            }

            root.setOnClickListener { p0 ->
                val previousItem = selectedItem
                selectedItem = p1
                notifyItemChanged(previousItem)
                notifyItemChanged(selectedItem)
                listener!!.onItemClicked(p1.toString())
            }
        }

    }

    override fun getItemCount(): Int {
        return 3
    }

    class FilterCatViewHolder(val binding : FilterCatItemBinding) : RecyclerView.ViewHolder(binding.root)

}