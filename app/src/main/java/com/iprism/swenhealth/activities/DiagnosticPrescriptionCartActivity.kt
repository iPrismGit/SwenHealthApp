package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityDiagnosticPrescriptionCartBinding
import com.iprism.swenhealth.databinding.ActivityDiagnosticTimeSlotsBinding

class DiagnosticPrescriptionCartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnosticPrescriptionCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDiagnosticPrescriptionCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        handleConfirm()
    }

    private fun handleConfirm() {
        binding.confirmBtn.setOnClickListener { p0 ->
            startActivity(Intent(this, SuccessActivity::class.java))
        }
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }

}