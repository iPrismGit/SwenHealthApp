package com.iprism.swenhealth.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.SelectDateItemBinding
import com.iprism.swenhealth.interfaces.OnDateClickListener

class DatesAdapter() : RecyclerView.Adapter<DatesAdapter.DateViewHolder> () {

    private lateinit var listener: OnDateClickListener

    private var selectedItem = 0
    fun setupListener(listener: OnDateClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DateViewHolder {
        var binding = SelectDateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DateViewHolder, @SuppressLint("RecyclerView") position: Int) {
      //  holder.binding.dateTxt.text = formattedDate.replace(" ", "\n")
        if (selectedItem == position) {
            holder.binding.cardView.strokeColor = ContextCompat.getColor(holder.binding.root.context, R.color.green)
            holder.binding.cardView.strokeWidth = 1
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#DAFFD0"))
        } else {
            holder.binding.cardView.strokeColor = ContextCompat.getColor(holder.binding.root.context, R.color.light_gray1)
            holder.binding.cardView.strokeWidth = 1
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        holder.binding.root.setOnClickListener(View.OnClickListener {
            val previousItem = selectedItem
            selectedItem = position
            notifyItemChanged(previousItem)
            notifyItemChanged(selectedItem)
            listener.onItemClick(position.toString())
        })
    }

    override fun getItemCount(): Int {
        return 10
    }

    class DateViewHolder(var binding: SelectDateItemBinding) : RecyclerView.ViewHolder(binding.root)
}