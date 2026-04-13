package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityHospitalAdmissionBookingDetailsBinding
import com.iprism.swenhealth.databinding.ActivityHospitalAmbulanceBookingDetailsBinding
import com.iprism.swenhealth.databinding.HospitalAdmissionBookingItemBinding

class HospitalAdmissionBookingDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalAdmissionBookingDetailsBinding
    private var bookingStatus = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHospitalAdmissionBookingDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        bookingStatus = intent.getStringExtra("bookingStatus").toString()
        setupUiData()
        handleBack()
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

    private fun setupUiData() {
        if (bookingStatus.equals("Ongoing", true)){
            binding.progressLine.setBackgroundColor(ContextCompat.getColor(this, R.color.gray5))
            binding.stepPlaced.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepProcessed.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.grey_img))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelProcessed.setTextColor(ContextCompat.getColor(this, R.color.thick_gray1))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.thick_gray1))
        } else{
            binding.progressLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.stepPlaced.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepProcessed.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelProcessed.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color)) }
    }
}