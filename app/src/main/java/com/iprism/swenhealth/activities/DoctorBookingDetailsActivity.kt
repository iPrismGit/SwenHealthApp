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
import com.iprism.swenhealth.databinding.ActivityDoctorBookingDetailsBinding

class DoctorBookingDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorBookingDetailsBinding
    private val bookingStatus by lazy { intent.getStringExtra("bookingStatus") }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDoctorBookingDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupUiData()
        handleNeedHelpLo()
        handleViewPrescriptionLL()
    }

    private fun handleViewPrescriptionLL() {
        binding.viewPrescriptionLl.setOnClickListener { p0 ->
            val intent = Intent(this, ViewDocumentsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun handleNeedHelpLo() {
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
            binding.viewPrescriptionLl.visibility = View.GONE

        } else{
            binding.progressLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.stepPlaced.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepProcessed.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelProcessed.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.viewPrescriptionLl.visibility = View.VISIBLE
        }
    }
}