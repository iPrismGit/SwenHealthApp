package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.OnlineDoctorCategoriesAdapter
import com.iprism.swenhealth.databinding.ActivityOnlineDoctorCategoriesBinding

class OnlineDoctorCategoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnlineDoctorCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOnlineDoctorCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupAdapter()
        handleContinueBtn()
    }

    private fun handleContinueBtn() {
        binding.continueBookingBtn.setOnClickListener { p0 ->
            startActivity(Intent(this, OnlineDoctorsActivity::class.java))
        }
    }

    private fun setupAdapter() {
        val adapter = OnlineDoctorCategoriesAdapter()
        binding.categoriesRv.adapter = adapter
        val layoutMultiplatform = GridLayoutManager(this, 4)
        binding.categoriesRv.layoutManager = layoutMultiplatform
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener {
            finish()
        }

    }
}