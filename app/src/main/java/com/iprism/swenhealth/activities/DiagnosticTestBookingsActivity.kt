package com.iprism.swenhealth.activities

import DiagnosticTestsBookingsViewPagerAdapter
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityDiagnosticTestBookingsBinding

class DiagnosticTestBookingsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDiagnosticTestBookingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDiagnosticTestBookingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val adapter = DiagnosticTestsBookingsViewPagerAdapter(this)
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.adapter = adapter
        binding.viewPager.setCurrentItem(0, false)
        handleBack()
        handleUpcomingLabTestsTxt()
        handleCompletedTxt()
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun handleUpcomingLabTestsTxt() {
        binding.upcomingLabTestsTxt.setOnClickListener(View.OnClickListener {
            binding.viewPager.setCurrentItem(0, false)
            binding.upcomingLabTestsTxt.setTextColor(Color.parseColor("#FFFFFF"))
            binding.upcomingLabTestsTxt.background = ContextCompat.getDrawable(this, R.drawable.checked_txt_bg)
            binding.completedTxt.setTextColor(Color.parseColor("#A8A8A8"))
            binding.completedTxt.background = ContextCompat.getDrawable(this, R.drawable.unchecked_txt_bg)
        })
    }

    private fun handleCompletedTxt() {
        binding.completedTxt.setOnClickListener(View.OnClickListener {
            binding.viewPager.setCurrentItem(1, false)
            binding.completedTxt.setTextColor(Color.parseColor("#FFFFFF"))
            binding.completedTxt.background = ContextCompat.getDrawable(this, R.drawable.checked_txt_bg)
            binding.upcomingLabTestsTxt.setTextColor(Color.parseColor("#A8A8A8"))
            binding.upcomingLabTestsTxt.background = ContextCompat.getDrawable(this, R.drawable.unchecked_txt_bg)
        })
    }

}