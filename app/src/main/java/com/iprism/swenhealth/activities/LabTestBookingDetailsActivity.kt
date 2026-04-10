package com.iprism.swenhealth.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityLabTestBookingDetailsBinding

class LabTestBookingDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLabTestBookingDetailsBinding
    private var bookingType = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLabTestBookingDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        bookingType = intent.getStringExtra("bookingType").toString()
    }

}