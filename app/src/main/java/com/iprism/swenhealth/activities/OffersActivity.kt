package com.iprism.swenhealth.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.CouponsAndOffersAdapter
import com.iprism.swenhealth.databinding.ActivityOffersBinding
import com.iprism.swenhealth.interfaces.OnCouponAndOfferItemClickListener
import com.iprism.swenhealth.utils.ToastUtils

class OffersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOffersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOffersBinding.inflate(layoutInflater)
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
        val adapter = CouponsAndOffersAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        binding.couponsRv.adapter = adapter
        binding.couponsRv.layoutManager = linearLayoutManager
        adapter.setOnDoctorItemClickListener(object  : OnCouponAndOfferItemClickListener{
            override fun onItemClicked(position: String) {
                ToastUtils.showSuccessCustomToast(this@OffersActivity, "Coupon Added Successfully..!")
                finish()
            }

        })
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }
}