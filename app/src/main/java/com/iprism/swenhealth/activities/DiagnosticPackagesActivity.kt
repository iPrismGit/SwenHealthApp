package com.iprism.swenhealth.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.DiagnosticPackagesAdapter
import com.iprism.swenhealth.databinding.ActivityDiagnosticPackagesBinding

class DiagnosticPackagesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnosticPackagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDiagnosticPackagesBinding.inflate(layoutInflater)
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
        val adapter = DiagnosticPackagesAdapter()
        val linearLayout = LinearLayoutManager(this)
        binding.diagnosticPackagesRv.adapter = adapter
        binding.diagnosticPackagesRv.layoutManager = linearLayout
    }

    private fun handleBack() {
       binding.backImg.setOnClickListener { v ->
           finish()
       }
    }

}