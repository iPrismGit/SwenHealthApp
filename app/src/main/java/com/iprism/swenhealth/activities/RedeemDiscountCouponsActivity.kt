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
import com.iprism.swenhealth.adapters.RedeemCouponsAdapter
import com.iprism.swenhealth.databinding.ActivityRedeemDiscountCouponsBinding
import com.iprism.swenhealth.databinding.FragmentMedicinesBinding
import com.iprism.swenhealth.interfaces.OnCouponAndOfferItemClickListener

class RedeemDiscountCouponsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRedeemDiscountCouponsBinding
    private var tag =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRedeemDiscountCouponsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tag = intent.getStringExtra("tag").toString()
        if (tag.equals("DiagnosticCoupons", true)){
            binding.titleTxt.text = "Diagnostic Test Coupons"
        }
        handleBack()
        setupCouponsRecyclerView()
    }

    private fun setupCouponsRecyclerView() {
        val adapter = RedeemCouponsAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        binding.counponsRv.adapter = adapter
        binding.counponsRv.layoutManager = linearLayoutManager
        adapter.setupListener(object : OnCouponAndOfferItemClickListener{
            override fun onItemClicked(position: String) {
                if (tag.equals("DiagnosticCoupons", true)){
                    val intent = Intent(this@RedeemDiscountCouponsActivity, HomeCareServiceHospitalActivity::class.java)
                    intent.putExtra("tag", tag)
                    startActivity(intent)
                }else{
                    val intent = Intent(this@RedeemDiscountCouponsActivity, SymptomCategoriesActivity::class.java)
                    intent.putExtra("tag", tag)
                    startActivity(intent)
                }
            }

        })
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { v ->
            finish()
        }
    }

}