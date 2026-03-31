package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.ServiceItemBinding
import com.iprism.swenhealth.interfaces.OnServiceItemClickListener
import okhttp3.internal.parseCookie

class MedicineCategoriesAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var listener: OnServiceItemClickListener

    fun setupListener(listener: OnServiceItemClickListener){
        this.listener = listener
    }


    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = ServiceItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return MedicineCategoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as MedicineCategoryItemViewHolder
        holder.binding.apply {
            categoryName.text = "Must Haves"
            root.setOnClickListener { p0 ->
                listener.onItemClick(p1)
            }
        }
    }

    override fun getItemCount(): Int {
       return 10
    }

    class MedicineCategoryItemViewHolder(var binding: ServiceItemBinding) : RecyclerView.ViewHolder(binding.root)
}