package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.OfferHospitalsAdapter
import com.iprism.swenhealth.databinding.ActivityOfferHospitalsBinding
import com.iprism.swenhealth.interfaces.OnHospitalClickListener

class OfferHospitalsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOfferHospitalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOfferHospitalsBinding.inflate(layoutInflater)
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
        val adapter = OfferHospitalsAdapter()
        binding.doctorsRv.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(this)
        binding.doctorsRv.layoutManager = linearLayoutManager
        adapter.setupListener(object : OnHospitalClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@OfferHospitalsActivity, HospitalDetailsActivity::class.java)
                intent.putExtra("Tag", "OfferHospital")
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