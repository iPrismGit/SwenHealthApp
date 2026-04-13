package com.iprism.swenhealth.activities

import PharmacyBookingViewPagerAdapter
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityPharmacyBookingsBinding

class PharmacyBookingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPharmacyBookingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPharmacyBookingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.headingTxt.text = getString(R.string.wellness_medicine_bookings)
        val adapter = PharmacyBookingViewPagerAdapter(this)
        binding.viewPager1.isUserInputEnabled = false
        binding.viewPager1.adapter = adapter
        binding.viewPager1.setCurrentItem(0, false)
        if (intent.hasExtra("tag")) {
            val tag = intent.getStringExtra("tag")
            if (tag.equals("wellness", true)) {
                binding.headingTxt.text = getString(R.string.wellness_medicine_bookings)
            }
        }
        handleBack()
        handleOnGoingOrdersTxt()
        handleCompletedOrdersTxt()
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun handleOnGoingOrdersTxt() {
        binding.ongoingOrdersTxt.setOnClickListener(View.OnClickListener {
            binding.viewPager1.setCurrentItem(0, false)
            binding.ongoingOrdersTxt.setTextColor(Color.parseColor("#FFFFFF"))
            binding.ongoingOrdersTxt.background =
                ContextCompat.getDrawable(this, R.drawable.checked_txt_bg)
            binding.completedOrdersTxt.setTextColor(Color.parseColor("#A8A8A8"))
            binding.completedOrdersTxt.background =
                ContextCompat.getDrawable(this, R.drawable.unchecked_txt_bg)
        })
    }

    private fun handleCompletedOrdersTxt() {
        binding.completedOrdersTxt.setOnClickListener(View.OnClickListener {
            binding.viewPager1.setCurrentItem(1, false)
            binding.completedOrdersTxt.setTextColor(Color.parseColor("#FFFFFF"))
            binding.completedOrdersTxt.background =
                ContextCompat.getDrawable(this, R.drawable.checked_txt_bg)
            binding.ongoingOrdersTxt.setTextColor(Color.parseColor("#A8A8A8"))
            binding.ongoingOrdersTxt.background =
                ContextCompat.getDrawable(this, R.drawable.unchecked_txt_bg)
        })
    }

}