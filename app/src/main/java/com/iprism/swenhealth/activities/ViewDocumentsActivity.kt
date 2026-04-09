package com.iprism.swenhealth.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.DocumentsListAdapter
import com.iprism.swenhealth.databinding.ActivityViewDocumentsBinding
import com.iprism.swenhealth.databinding.MedLockerItemBinding

class ViewDocumentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewDocumentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityViewDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupAdapter()
        binding.documentsNameTxt.text = "Swen Documents"
    }

    private fun setupAdapter() {
        val adapter = DocumentsListAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        binding.documentsRv.adapter = adapter
        binding.documentsRv.layoutManager = linearLayoutManager
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }

}