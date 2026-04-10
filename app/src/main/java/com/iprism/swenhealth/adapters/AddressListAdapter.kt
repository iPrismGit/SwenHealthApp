package com.iprism.swenhealth.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iprism.swenhealth.databinding.AddressItemBinding
import com.iprism.swenhealth.interfaces.OnAddressItemClickListener

class AddressListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listener: OnAddressItemClickListener? = null

    fun setupListener(listener: OnAddressItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): RecyclerView.ViewHolder {
        val binding = AddressItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return AddressItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as AddressItemViewHolder
        holder.binding.apply {
            root.setOnClickListener {
                listener?.onItemClicked(addressTxt.text.toString())
            }

            if (p1 == 0){
                holder.binding.button.visibility = View.VISIBLE
                holder.binding.makeDefaultAddressTxt.visibility = View.GONE
            }else{
                holder.binding.button.visibility = View.GONE
                holder.binding.makeDefaultAddressTxt.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return 5
    }

    class AddressItemViewHolder(var binding : AddressItemBinding) : RecyclerView.ViewHolder(binding.root)
}