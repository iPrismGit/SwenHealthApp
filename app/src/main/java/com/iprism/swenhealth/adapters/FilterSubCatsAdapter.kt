package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.FilterSubcatItemBinding
import com.iprism.swenhealth.interfaces.OnFilterSpecialityItemActionListener

class FilterSubCatsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listener: OnFilterSpecialityItemActionListener? = null

    fun setListener(listener: OnFilterSpecialityItemActionListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = FilterSubcatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterSubCatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as FilterSubCatViewHolder
        holder.binding.checkBox.setOnClickListener(View.OnClickListener {
            val status: Boolean = holder.binding.checkBox.isChecked
            if (status) {
                listener!!.onFilterValueClicked(position)
            } else {
                listener!!.onFilterValueClicked(position)
            }

        })

    }

    override fun getItemCount(): Int {
        return 7
    }

    class FilterSubCatViewHolder(val binding: FilterSubcatItemBinding) : RecyclerView.ViewHolder(binding.root)
}
