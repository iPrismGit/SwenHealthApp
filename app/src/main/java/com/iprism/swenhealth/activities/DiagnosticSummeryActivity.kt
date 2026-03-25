package com.iprism.swenhealth.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.TestsAdapter
import com.iprism.swenhealth.databinding.ActivityDiagnosticSummeryBinding
import com.iprism.swenhealth.databinding.LabTestBillDetailsBottomSheetBinding
import com.iprism.swenhealth.databinding.PaymentTypeBottomSheetBinding
import com.iprism.swenhealth.databinding.TestsBottomSheetBinding

class DiagnosticSummeryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnosticSummeryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDiagnosticSummeryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        handleCouponsLL()
        handlePayNowBtn()
        handleBillDetailsTxt()
        handleIncludeTestTxt()
    }

    private fun handleBillDetailsTxt() {
        binding.viewDetailsTxt.setOnClickListener(View.OnClickListener {
            showBillDetailsBottomSheet(this)
        })
    }

    private fun handlePayNowBtn() {
        binding.payNowBtn.setOnClickListener { view ->
            showPaymentTypeBottomSheet(this)
          //  bookDiagnostic("online", "12345")
        }
    }

    private fun handleIncludeTestTxt() {
        binding.numberOfTestsTxt.setOnClickListener(View.OnClickListener {
            showTestsSheet()
        })
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
    @SuppressLint("SetTextI18n")
    private fun showBillDetailsBottomSheet(context: Context) {
        val bottomSheetDialog = BottomSheetDialog(context)
        val labTestSelectMembersBottomSheetBinding = LabTestBillDetailsBottomSheetBinding.inflate(
            LayoutInflater.from(context))
        bottomSheetDialog.setContentView(labTestSelectMembersBottomSheetBinding.root)
        bottomSheetDialog.setOnShowListener { dialog -> val bottomSheet = (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.setBackgroundResource(R.drawable.top_edges_bg)
        }
        labTestSelectMembersBottomSheetBinding.crossImg.setOnClickListener(View.OnClickListener {
            bottomSheetDialog.cancel()
        })
//        labTestSelectMembersBottomSheetBinding.coupontDiscountTxt.text = "₹${details!!.couponDiscount}"
//        labTestSelectMembersBottomSheetBinding.totalTxt.text = "₹${details!!.consultationFee}"
//        labTestSelectMembersBottomSheetBinding.itemTotalTxt.text = "₹${price!!.discontPrice}"
        bottomSheetDialog.show()
    }

    @SuppressLint("SetTextI18n")
    private fun showTestsSheet() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val testsBottomSheetBinding = TestsBottomSheetBinding.inflate(LayoutInflater.from(this))
        bottomSheetDialog.setContentView(testsBottomSheetBinding.root)
        bottomSheetDialog.setOnShowListener { dialog -> val bottomSheet = (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.setBackgroundResource(R.drawable.top_edges_bg)
        }
        testsBottomSheetBinding.crossImg.setOnClickListener(View.OnClickListener {
            bottomSheetDialog.cancel()
        })
//        testsBottomSheetBinding.numberOfTestsTxt.text = "Contains" + " ${tests.size} " + "tests"
        val testsAdapter = TestsAdapter()
//        Log.d("tests", tests.toString())
        testsBottomSheetBinding.testsRv.layoutManager = LinearLayoutManager(this)
        testsBottomSheetBinding.testsRv.adapter = testsAdapter
        bottomSheetDialog.show()
    }

    private fun handleCouponsLL() {
        binding.couponsLl.setOnClickListener { view ->
            val intent = Intent(this, OffersActivity::class.java)
            intent.putExtra("tag", "healthCheckups")
            startActivity(intent)
         //   launcher.launch(intent)
        }
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { view ->
            finish()
        }
    }
}