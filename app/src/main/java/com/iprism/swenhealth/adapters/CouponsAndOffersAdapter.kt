package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.CouponOfferItemBinding
import com.iprism.swenhealth.interfaces.OnCouponAndOfferItemClickListener

class CouponsAndOffersAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder> () {

    private var onCouponItemClickListener: OnCouponAndOfferItemClickListener? = null

    fun setOnDoctorItemClickListener(onCouponItemClickListener: OnCouponAndOfferItemClickListener?) {
        this.onCouponItemClickListener = onCouponItemClickListener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = CouponOfferItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return CouponViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as CouponViewHolder
        holder.binding.applyTxt.setOnClickListener(View.OnClickListener {
            onCouponItemClickListener!!.onItemClicked(holder.position.toString())
        })
    }

    override fun getItemCount(): Int {
       return 5
    }

    class CouponViewHolder(var binding: CouponOfferItemBinding) : RecyclerView.ViewHolder(binding.root)
}