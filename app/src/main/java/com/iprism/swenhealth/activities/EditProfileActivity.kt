package com.iprism.swenhealth.activities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityEditProfileBinding
import com.iprism.swenhealth.databinding.HospitalAdmissionBookingItemBinding
import com.iprism.swenhealth.utils.ToastUtils

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        handleStep1Txt()
        handleStep2Txt()
        handleStep3Txt()
        handleStep4Txt()
        handleStep5Txt()
        handleUpdateBtn()
    }

    private fun handleUpdateBtn() {
        binding.updateBtn.setOnClickListener { p0 ->
            ToastUtils.showSuccessCustomToast(this, "Profile updated successfully..!")
            finish()
        }
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun handleStep1Txt() {
        binding.step1Txt.setOnClickListener(View.OnClickListener {
            binding.relationshipLl.visibility = View.GONE
//            if (profileResponse!!.isNotEmpty()) {
//                showDetails(profileResponse!![0])
//            }
        })
    }

    private fun handleStep2Txt() {
        binding.step2Txt.setOnClickListener(View.OnClickListener {
            binding.relationshipLl.visibility = View.VISIBLE
//            if (profileResponse!!.size >= 2) {
//                showDetails(profileResponse!![1])
//            } else {
//                showDetails(null)
//            }
        })
    }

    private fun handleStep3Txt() {
        binding.step3Txt.setOnClickListener(View.OnClickListener {
            binding.relationshipLl.visibility = View.VISIBLE
//            if (profileResponse!!.size >= 3) {
//                showDetails(profileResponse!![2])
//            } else {
//                showDetails(null)
//            }
        })
    }

    private fun handleStep4Txt() {
        binding.step4Txt.setOnClickListener(View.OnClickListener {
            binding.relationshipLl.visibility = View.VISIBLE
//            if (profileResponse!!.size >= 4) {
//                showDetails(profileResponse!![3])
//            } else {
//                showDetails(null)
//            }
        })
    }

    private fun handleStep5Txt() {
        binding.step5Txt.setOnClickListener(View.OnClickListener {
            binding.relationshipLl.visibility = View.VISIBLE
//            if (profileResponse!!.size >= 5) {
//                showDetails(profileResponse!![4])
//            } else {
//                showDetails(null)
//            }
        })
    }

}