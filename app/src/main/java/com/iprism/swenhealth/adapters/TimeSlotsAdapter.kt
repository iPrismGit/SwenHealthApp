package com.iprism.swenhealth.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.TimeItemBinding
import com.iprism.swenhealth.interfaces.OnSlotItemClickListener


class TimeSlotsAdapter() : RecyclerView.Adapter<TimeSlotsAdapter.TimeSlotViewHolder>() {

    private var selectedPosition = -1

    private var onTimeItemClickListener: OnSlotItemClickListener? = null

    fun setOnItemClickListener(onTimeItemClickListener: OnSlotItemClickListener?) {
        this.onTimeItemClickListener = onTimeItemClickListener
    }

    fun clearSelection() {
        selectedPosition = -1
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TimeSlotViewHolder {
        val binding = TimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TimeSlotViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TimeSlotViewHolder,
        position: Int
    ) {
        if (selectedPosition == position) {
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#DAFFD0"))
            holder.binding.cardView.strokeColor = ContextCompat.getColor(holder.binding.root.context, R.color.parrot_green)
            holder.binding.cardView.strokeWidth = 1
        } else {
            holder.binding.cardView.strokeColor = ContextCompat.getColor(holder.binding.root.context, R.color.light_gray1)
            holder.binding.cardView.setCardBackgroundColor(Color.WHITE)
            holder.binding.cardView.strokeWidth = 1
        }

        holder.binding.root.setOnClickListener(View.OnClickListener {

                val previousSelected = selectedPosition
                selectedPosition = holder.adapterPosition
                notifyItemChanged(previousSelected)
                notifyItemChanged(selectedPosition)
                onTimeItemClickListener!!.onItemClick(position.toString(), "")


        })
    }

    override fun getItemCount(): Int {
        return 12
    }

    class TimeSlotViewHolder(var binding: TimeItemBinding) : RecyclerView.ViewHolder(binding.root)

}