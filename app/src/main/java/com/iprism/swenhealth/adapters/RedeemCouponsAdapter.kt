package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.adapters.CategoriesAdapter.CategoryViewHolder
import com.iprism.swenhealth.databinding.CouponItemBinding
import com.iprism.swenhealth.interfaces.OnCouponAndOfferItemClickListener

class RedeemCouponsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var listener: OnCouponAndOfferItemClickListener

    fun setupListener(listener: OnCouponAndOfferItemClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = CouponItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return RedeemCouponItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as RedeemCouponItemViewHolder
        val context = holder.binding.root.context
        holder.binding.apply {
            root.setOnClickListener { p0 ->
                listener.onItemClicked(p1.toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return 12
    }

    class RedeemCouponItemViewHolder(var binding: CouponItemBinding) : RecyclerView.ViewHolder(binding.root)

}