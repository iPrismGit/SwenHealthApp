package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.MedicineCategoriesAdapter
import com.iprism.swenhealth.databinding.ActivityPharmacyMedicineCategoriesBinding
import com.iprism.swenhealth.interfaces.OnServiceItemClickListener
import com.iprism.swenhealth.utils.ToastUtils

class PharmacyMedicineCategoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPharmacyMedicineCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPharmacyMedicineCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupAdapter()
        handleBookMedicineBtn()
        handlePrescriptionLo()
        handleCallLo()
        handleWhatsappLo()
    }

    private fun handleWhatsappLo() {
        binding.whatsappLo.setOnClickListener { p0 ->
            ToastUtils.showSuccessCustomToast(this, "Whatsapp Button Clicked")
        }
    }

    private fun handleCallLo() {
        binding.callLo.setOnClickListener { p0 ->
            ToastUtils.showSuccessCustomToast(this, "Call Now Button Clicked")
        }
    }

    private fun handlePrescriptionLo() {
        binding.prescriptionLo.setOnClickListener { p0 ->
            startActivity(Intent(this, MedicinePrescriptionBookingActivity::class.java))
        }
    }

    private fun handleBookMedicineBtn() {
        binding.bookMedicineBtn.setOnClickListener { p0 ->
            startActivity(Intent(this, PharmacyProductsActivity::class.java))
        }
    }

    private fun setupAdapter() {
        val adapter = MedicineCategoriesAdapter()
        val linearLayoutManager = GridLayoutManager(this, 3)
        binding.categoriesRv.layoutManager = linearLayoutManager
        binding.categoriesRv.adapter = adapter
        adapter.setupListener(object : OnServiceItemClickListener{
            override fun onItemClick(position: Int) {
                Log.d("CatId", position.toString())
            }

        })
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }
}