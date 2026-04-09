package com.iprism.swenhealth.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityContactUsBinding
import com.iprism.swenhealth.utils.ToastUtils

class ContactUsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        handleContinue()
        handleCallNowBtn()
    }

    private fun handleCallNowBtn() {
        binding.callNowBtn.setOnClickListener { p0 ->
            ToastUtils.showSuccessCustomToast(this, "Clicked on Call Now..!")
            finish()
        }
    }

    private fun handleContinue() {
        binding.continueBtn.setOnClickListener { p0 ->
            ToastUtils.showSuccessCustomToast(this, "Report Submitted Successfully..!")
            finish()
        }
    }

    private fun handleBack() {
        binding.backIv.setOnClickListener { p0 ->
            finish()
        }
    }
}