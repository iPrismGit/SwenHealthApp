package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityHospitalAmbulanceBookingDetailsBinding
import com.iprism.swenhealth.utils.ToastUtils

class HospitalAmbulanceBookingDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalAmbulanceBookingDetailsBinding
    private var bookingStatus =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHospitalAmbulanceBookingDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        bookingStatus = intent.getStringExtra("bookingStatus").toString()
        handleBack()
        handleCallLo()
        handleTrackLo()
        handleNeedHelpBtn()
        setupUi()
    }

    private fun setupUi() {
        if (bookingStatus.equals("Ongoing", true)){
            binding.progressLine.setBackgroundColor(ContextCompat.getColor(this, R.color.gray5))
            binding.progressLine2.setBackgroundColor(ContextCompat.getColor(this, R.color.gray5))
            binding.stepPlaced.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepProcessed.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.grey_img))
            binding.stepCompleted.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.grey_img))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelProcessed.setTextColor(ContextCompat.getColor(this, R.color.thick_gray1))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.thick_gray1))
         //   binding.viewPrescriptionLl.visibility = View.GONE

        } else{
            binding.progressLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.progressLine2.setBackgroundColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.stepPlaced.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepProcessed.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepCompleted.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelProcessed.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelCompleted.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            //binding.viewPrescriptionLl.visibility = View.VISIBLE
        }
    }

    private fun handleNeedHelpBtn() {
        binding.needHelpTxt.setOnClickListener { p0 ->
            startActivity(Intent(this, ContactUsActivity::class.java))
        }
    }

    private fun handleTrackLo() {
        binding.trackAmbulanceTxt.setOnClickListener { p0 ->
            ToastUtils.showSuccessCustomToast(this, "Navigate to Maps..!")
        }
    }

    private fun handleCallLo() {
        binding.callLl1.setOnClickListener { p0 ->
            ToastUtils.showSuccessCustomToast(this, "Calling to the Ambulance Driver..!")
        }
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener {
            finish()
        }
    }

}