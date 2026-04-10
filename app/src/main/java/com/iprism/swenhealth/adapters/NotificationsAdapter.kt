package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.LabTestBookingItemBinding
import com.iprism.swenhealth.databinding.NotificationItemBinding
import okhttp3.internal.parseCookie

class NotificationsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = NotificationItemBinding.inflate(LayoutInflater.from(p0.context),p0, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as NotificationViewHolder
    }

    override fun getItemCount(): Int {
        return 10
    }

    class NotificationViewHolder(var binding: NotificationItemBinding) : RecyclerView.ViewHolder(binding.root)

}