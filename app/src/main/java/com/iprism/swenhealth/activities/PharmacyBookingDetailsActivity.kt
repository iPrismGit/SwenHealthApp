package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.MedicineBookedAdapter
import com.iprism.swenhealth.adapters.MedicineBookingsAdapter
import com.iprism.swenhealth.databinding.ActivityPharmacyBookingDetailsBinding
import com.iprism.swenhealth.interfaces.OnBookingItemClickListener

class PharmacyBookingDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPharmacyBookingDetailsBinding
    private var bookingType = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPharmacyBookingDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        bookingType = intent.getStringExtra("bookingType").toString()
        setupAdapter()
        handleBack()
        setupUi()
        handleNeedHelpBtn()
    }

    private fun handleNeedHelpBtn() {
        binding.needHelpTxt.setOnClickListener { p0 ->
            startActivity(Intent(this, ContactUsActivity::class.java))
        }
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }

    private fun setupAdapter() {
        val adapter = MedicineBookedAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        binding.productsRv.layoutManager = linearLayoutManager
        binding.productsRv.adapter = adapter
    }

    private fun setupUi() {
        if (bookingType.equals("Ongoing", true)){
            binding.progressLine.setBackgroundColor(ContextCompat.getColor(this, R.color.gray5))
            binding.progressLine2.setBackgroundColor(ContextCompat.getColor(this, R.color.gray5))
            binding.stepPlaced.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepProcessed.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.grey_img))
            binding.stepCompleted.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.grey_img))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelProcessed.setTextColor(ContextCompat.getColor(this, R.color.thick_gray1))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.thick_gray1))
          //  binding.viewPrescriptionLl.visibility = View.GONE

        } else{
            binding.progressLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.progressLine2.setBackgroundColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.stepPlaced.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepProcessed.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepCompleted.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelProcessed.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelCompleted.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
          //  binding.viewPrescriptionLl.visibility = View.VISIBLE
        }
    }

}