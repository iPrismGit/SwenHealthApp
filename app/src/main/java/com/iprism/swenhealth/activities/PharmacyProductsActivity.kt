package com.iprism.swenhealth.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.MedicineProductsAdapter
import com.iprism.swenhealth.databinding.ActivityPharmacyProductsBinding

class PharmacyProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPharmacyProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPharmacyProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupProductsAdapter()
    }

    private fun setupProductsAdapter() {
        val adapter = MedicineProductsAdapter()
        val linearLayoutManager = GridLayoutManager(this, 2)
        binding.productsRv.adapter = adapter
        binding.productsRv.layoutManager = linearLayoutManager
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }
}