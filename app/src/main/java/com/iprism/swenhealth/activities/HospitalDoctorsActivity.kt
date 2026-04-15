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
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.HospitalDoctorsAdapter
import com.iprism.swenhealth.databinding.ActivityHospitalDoctorsBinding
import com.iprism.swenhealth.databinding.CouponBillSummeryBottomSheetBinding
import com.iprism.swenhealth.databinding.PaymentTypeBottomSheetBinding
import com.iprism.swenhealth.databinding.PharmacyCartItemBinding
import com.iprism.swenhealth.interfaces.OnAppointmentDoctorItemClickListener

class HospitalDoctorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalDoctorsBinding
    private var tag = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHospitalDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tag = intent.getStringExtra("tag").toString()
        handleBack()
        setupDoctorsAdapter()
    }

    private fun setupDoctorsAdapter() {
        val adapter = HospitalDoctorsAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        binding.doctorsRv.layoutManager = linearLayoutManager
        binding.doctorsRv.adapter = adapter
        adapter.setupListener(object  : OnAppointmentDoctorItemClickListener{

            override fun onItemClicked(doctor: String) {
                if (tag.equals("Coupons", true)){
                    showBillBottomSheet(this@HospitalDoctorsActivity)
                } else{
                    val intent = Intent(this@HospitalDoctorsActivity, OnlineDoctorProfileActivity::class.java)
                    intent.putExtra("tag", "Book Appointment")
                    startActivity(intent)
                }
            }

        })
    }

    @SuppressLint("SetTextI18n")
    private fun showBillBottomSheet(context: Context) {
        val bottomSheetDialog = BottomSheetDialog(context)
        val labTestSelectMembersBottomSheetBinding = CouponBillSummeryBottomSheetBinding.inflate(
            LayoutInflater.from(context))
        bottomSheetDialog.setContentView(labTestSelectMembersBottomSheetBinding.root)
        bottomSheetDialog.setOnShowListener { dialog -> val bottomSheet = (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.setBackgroundResource(R.drawable.top_edges_bg)
        }
        labTestSelectMembersBottomSheetBinding.crossImg.setOnClickListener(View.OnClickListener {
            bottomSheetDialog.cancel()
        })

        labTestSelectMembersBottomSheetBinding.proceedBtn.setOnClickListener { p0 ->
            val intent = Intent(this, SuccessActivity::class.java)
            intent.putExtra("tag", "Free Doctor Consultations Booked ")
            startActivity(intent)
        }
//        labTestSelectMembersBottomSheetBinding.coupontDiscountTxt.text = "₹${details!!.couponDiscount}"
//        labTestSelectMembersBottomSheetBinding.totalTxt.text = "₹${details!!.consultationFee}"
//        labTestSelectMembersBottomSheetBinding.itemTotalTxt.text = "₹${price!!.discontPrice}"
        bottomSheetDialog.show()
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }

}