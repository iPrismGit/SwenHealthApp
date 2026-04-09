package com.iprism.swenhealth.adapters

import android.annotation.SuppressLint
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ImageItemBinding

import com.iprism.swenhealth.interfaces.OnImageDeleteActionListener

class ImagesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var checkInImages: List<Uri>? = null
    private var onImageDeleteActionListener: OnImageDeleteActionListener? = null

    fun setCheckInImages(checkInImages: List<Uri>?) {
        this.checkInImages = checkInImages
        notifyDataSetChanged()
    }

    fun setOnDeleteActionListener(onImageDeleteActionListener: OnImageDeleteActionListener?) {
        this.onImageDeleteActionListener = onImageDeleteActionListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: RecyclerView.ViewHolder,
        p1: Int
    ) {
        val holder = p0 as ImageViewHolder
        val taskImage = checkInImages!![p1]
        val context = holder.itemView.context
        val mimeType = context.contentResolver.getType(taskImage)
        if (mimeType == "application/pdf") {

            holder.binding.checkInImg.setImageResource(R.drawable.ic_img)
            holder.binding.checkInImg.setBackgroundColor(ContextCompat.getColor(context, R.color.blue))
            val cursor = context.contentResolver.query(taskImage, null, null, null, null)
            cursor?.use {
                if (it.moveToFirst()) {
                    val displayName = it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                    Log.d("PDF_NAME", "Selected file: $displayName")
                    holder.binding.pdfNameTxt.visibility = View.VISIBLE
                    holder.binding.pdfNameTxt.text = displayName
                }
            }
        } else {
            Glide.with(holder.itemView)
                .load(taskImage)
                .into(holder.binding.checkInImg)
            holder.binding.pdfNameTxt.visibility = View.GONE
        }
        holder.binding.deleteImg.setOnClickListener { view: View? ->
            onImageDeleteActionListener!!.onDelete(p1)
        }
    }


    override fun getItemCount(): Int {
        return checkInImages!!.size
    }

    class ImageViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root)
}