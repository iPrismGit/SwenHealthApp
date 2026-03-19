package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.databinding.ActivityLocationPermissionsBinding
import com.iprism.swenhealth.utils.ToastUtils

class LocationPermissionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLocationPermissionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLocationPermissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        handleEnableBtn()
    }

    private fun handleEnableBtn() {
       binding.enableBtn.setOnClickListener { p0 ->
           ToastUtils.showSuccessCustomToast(this, "Location Permissions Enabled Successfully..!")
           startActivity(Intent(this, MainActivity::class.java))
       }
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }
}