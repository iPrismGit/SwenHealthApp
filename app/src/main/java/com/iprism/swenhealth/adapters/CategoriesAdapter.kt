package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ServiceItemBinding

class CategoriesAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = ServiceItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as CategoryViewHolder
        val content = holder.binding.root.context
        if (holder.position == 3){
            holder.binding.categoryName.text = "See All Services"
            holder.binding.categoryImg.setImageDrawable(ContextCompat.getDrawable(content, R.drawable.see_all_services_img))
        }
    }

    override fun getItemCount(): Int {
       return 4
    }

    class CategoryViewHolder(var binding: ServiceItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}