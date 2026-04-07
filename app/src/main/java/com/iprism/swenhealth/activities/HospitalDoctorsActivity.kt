package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.HospitalDoctorsAdapter
import com.iprism.swenhealth.databinding.ActivityHospitalDoctorsBinding
import com.iprism.swenhealth.databinding.PharmacyCartItemBinding
import com.iprism.swenhealth.interfaces.OnAppointmentDoctorItemClickListener

class HospitalDoctorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalDoctorsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHospitalDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupDoctorsAdapter()
    }

    private fun setupDoctorsAdapter() {
        val adapter = HospitalDoctorsAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        binding.doctorsRv.layoutManager = linearLayoutManager
        binding.doctorsRv.adapter = adapter
        adapter.setupListener(object  : OnAppointmentDoctorItemClickListener{
            override fun onItemClicked(doctor: String) {
                val intent = Intent(this@HospitalDoctorsActivity, OnlineDoctorProfileActivity::class.java)
                intent.putExtra("tag", "Book Appointment")
                startActivity(intent)
            }

        })
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }

}