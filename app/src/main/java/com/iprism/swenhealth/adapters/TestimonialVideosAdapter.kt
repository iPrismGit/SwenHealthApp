package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.VideoItemBinding
import com.iprism.swenhealth.interfaces.TestimonialClickListener

class TestimonialVideosAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var listener: TestimonialClickListener

    fun setupListener(listener: TestimonialClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = VideoItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return TestimonialViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as TestimonialViewHolder
        holder.binding.apply {
            root.setOnClickListener { p0 ->
                listener.onVideoClick("")
            }
        }
    }

    override fun getItemCount(): Int {
       return 10
    }

    class TestimonialViewHolder(val binding: VideoItemBinding) : RecyclerView.ViewHolder(binding.root)
}