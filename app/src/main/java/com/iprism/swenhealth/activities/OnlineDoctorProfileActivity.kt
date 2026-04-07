package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityOnlineDoctorProfileBinding
import com.iprism.swenhealth.databinding.ActivityOnlineDoctorsBinding

class OnlineDoctorProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnlineDoctorProfileBinding
    private var tag = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOnlineDoctorProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tag = intent.getStringExtra("tag").toString()
        handleBack()
        handleContinueBtn()
        handleHospitalVisitBtn()
        setupData()
    }

    private fun handleHospitalVisitBtn() {
        binding.hospitalVisitBtn.setOnClickListener { p0 ->
            startActivity(Intent(this, OnlineDoctorTimeSlotsActivity::class.java))
        }
    }

    private fun setupData() {
        if (tag.equals("Online Consultation", true)){
            binding.onlineConsultBtn.visibility = View.VISIBLE
            binding.hospitalVisitFeeLl.visibility = View.GONE
            binding.bookAppointmentBtn.visibility = View.GONE
            binding.hospitalVisitBtn.visibility = View.GONE
        } else if (tag.equals("Book Appointment", true)){
            binding.onlineConsultBtn.visibility = View.VISIBLE
            binding.bookAppointmentBtn.visibility = View.GONE
            binding.hospitalVisitBtn.visibility = View.VISIBLE
        } else {
            binding.onlineConsultBtn.visibility = View.GONE
            binding.bookAppointmentBtn.visibility = View.GONE
            binding.hospitalVisitBtn.visibility = View.VISIBLE
        }
    }

    private fun handleContinueBtn() {
        binding.onlineConsultBtn.setOnClickListener { p0 ->
            startActivity(Intent(this, OnlineDoctorTimeSlotsActivity::class.java))
        }
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }

}