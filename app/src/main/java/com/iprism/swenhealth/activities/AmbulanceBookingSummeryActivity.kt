package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityAmbulanceBookingSummeryBinding

class AmbulanceBookingSummeryActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAmbulanceBookingSummeryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAmbulanceBookingSummeryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        handleConfirmBookingBtn()
    }

    private fun handleConfirmBookingBtn() {
        binding.confirmBtn.setOnClickListener { p0 ->
            val intent = Intent(this, SuccessActivity::class.java)
            intent.putExtra("tag", "Ambulance Booking Confirmed")
            startActivity(intent)
        }
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }
}