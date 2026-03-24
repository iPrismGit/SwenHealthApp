package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.DoctorAppointmentCategoriesAdapter
import com.iprism.swenhealth.databinding.ActivityDoctorAppointmentCategoriesBinding
import com.iprism.swenhealth.interfaces.OnServiceItemClickListener

class DoctorAppointmentCategoriesActivity : AppCompatActivity() {


    private lateinit var binding: ActivityDoctorAppointmentCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDoctorAppointmentCategoriesBinding.inflate(layoutInflater)
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
        val adapter = DoctorAppointmentCategoriesAdapter()
        binding.categoriesRv.adapter = adapter
        val layoutManager = GridLayoutManager(this, 4)
        binding.categoriesRv.layoutManager = layoutManager
        adapter.setupListener(object : OnServiceItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@DoctorAppointmentCategoriesActivity, MainActivity::class.java)
                intent.putExtra("fragment", "Hospitals")
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