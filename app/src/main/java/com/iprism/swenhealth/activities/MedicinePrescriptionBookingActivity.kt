package com.iprism.swenhealth.activities

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
import com.iprism.swenhealth.databinding.ActivityMedicinePrescriptionBookingBinding
import com.iprism.swenhealth.databinding.ChooseOrderTypeBsBinding

class MedicinePrescriptionBookingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMedicinePrescriptionBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMedicinePrescriptionBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        handleContinueBtn()
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }

    private fun handleContinueBtn() {
        binding.continueBtn.setOnClickListener { p0 ->
            showOrderTypeBs(this)
            //startActivity(Intent(this, MedicinePrescriptionSummeryActivity::class.java))
        }
    }

    private fun showOrderTypeBs(context: Context) {
        val bottomSheetDialog = BottomSheetDialog(context)
        val chooseOrderTypeBsBinding =
            ChooseOrderTypeBsBinding.inflate(LayoutInflater.from(context))
        bottomSheetDialog.setContentView(chooseOrderTypeBsBinding.root)
        bottomSheetDialog.setOnShowListener { dialog ->
            val bottomSheet =
                (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.setBackgroundResource(R.drawable.top_edges_bg)
        }
        chooseOrderTypeBsBinding.crossImg.setOnClickListener {

            bottomSheetDialog.cancel()
        }
        chooseOrderTypeBsBinding.pickUpOrderLl.setOnClickListener {

            bottomSheetDialog.cancel()
            startActivity(Intent(this, MedicinePrescriptionSummeryActivity::class.java))
        }
        chooseOrderTypeBsBinding.homeDeliveryLl.setOnClickListener {

            bottomSheetDialog.cancel()
            startActivity(Intent(this, MedicinePrescriptionSummeryActivity::class.java))
        }
        bottomSheetDialog.show()
    }
}