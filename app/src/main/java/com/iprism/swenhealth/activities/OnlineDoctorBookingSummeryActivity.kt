package com.iprism.swenhealth.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityOnlineDoctorBookingSummeryBinding
import com.iprism.swenhealth.databinding.ActivityOnlineDoctorProfileBinding
import com.iprism.swenhealth.databinding.PaymentTypeBottomSheetBinding

class OnlineDoctorBookingSummeryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnlineDoctorBookingSummeryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOnlineDoctorBookingSummeryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        handleSelectBtn()
        handleContinueBtn()
    }

    private fun handleContinueBtn() {
        binding.payNowBtn.setOnClickListener { p0 ->
            showPaymentTypeBottomSheet(this)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showPaymentTypeBottomSheet(context: Context) {
        val bottomSheetDialog = BottomSheetDialog(context)
        val labTestSelectMembersBottomSheetBinding = PaymentTypeBottomSheetBinding.inflate(
            LayoutInflater.from(context))
        bottomSheetDialog.setContentView(labTestSelectMembersBottomSheetBinding.root)
        bottomSheetDialog.setOnShowListener { dialog -> val bottomSheet = (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.setBackgroundResource(R.drawable.top_edges_bg)
        }
        labTestSelectMembersBottomSheetBinding.crossImg.setOnClickListener(View.OnClickListener {
            bottomSheetDialog.cancel()
        })

        labTestSelectMembersBottomSheetBinding.paymentGatewayLo.setOnClickListener { p0 ->
            startActivity(Intent(this, SuccessActivity::class.java))
        }

        labTestSelectMembersBottomSheetBinding.walletLo.setOnClickListener { p0 ->
            startActivity(Intent(this, SuccessActivity::class.java))
        }
//        labTestSelectMembersBottomSheetBinding.coupontDiscountTxt.text = "₹${details!!.couponDiscount}"
//        labTestSelectMembersBottomSheetBinding.totalTxt.text = "₹${details!!.consultationFee}"
//        labTestSelectMembersBottomSheetBinding.itemTotalTxt.text = "₹${price!!.discontPrice}"
        bottomSheetDialog.show()
    }

    private fun handleSelectBtn() {
        binding.selectBtn.setOnClickListener { p0 ->
            startActivity(Intent(this, OffersActivity::class.java))
        }
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }
}