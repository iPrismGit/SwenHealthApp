package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.OnlineDoctorsAdapter
import com.iprism.swenhealth.databinding.ActivityOnlineDoctorCategoriesBinding
import com.iprism.swenhealth.databinding.ActivityOnlineDoctorsBinding
import com.iprism.swenhealth.interfaces.OnAppointmentDoctorItemClickListener

class OnlineDoctorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnlineDoctorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOnlineDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupAdapter()
    }

    private fun setupAdapter() {
        val adapter = OnlineDoctorsAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.doctorsRv.layoutManager = layoutManager
        binding.doctorsRv.adapter = adapter
        adapter.setOnDoctorItemClickListener(object  : OnAppointmentDoctorItemClickListener{
            override fun onItemClicked(doctor: String) {
                startActivity(Intent(this@OnlineDoctorsActivity, OnlineDoctorProfileActivity::class.java))
            }

        })
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }
}