package com.iprism.swenhealth.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.CategoriesAdapter
import com.iprism.swenhealth.adapters.DiagnosticPackagesAdapter
import com.iprism.swenhealth.adapters.MedicineCategoriesAdapter
import com.iprism.swenhealth.adapters.OnlineDoctorCategoriesAdapter
import com.iprism.swenhealth.databinding.ActivityHospitalDetailsBinding
import com.iprism.swenhealth.databinding.BookAmbulanceBottomSheetBinding
import com.iprism.swenhealth.databinding.LabTestBillDetailsBottomSheetBinding
import com.iprism.swenhealth.interfaces.OnPackageClickListener

class HospitalDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHospitalDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupBtnsStyling(binding.hospitalBookingBtn, binding.medicinesBtn, binding.diagnosticsBtn)
        binding.hospitalSpecialitiesLo.visibility = android.view.View.VISIBLE
        binding.admitBtn.visibility = android.view.View.VISIBLE
        binding.continueBookingBtn.visibility = android.view.View.VISIBLE
        binding.bookMedicineBtn.visibility = android.view.View.GONE
        binding.diagnosticContinueLo.visibility = android.view.View.GONE
        binding.diagnosticLo.visibility = android.view.View.GONE
        handleHospitalBookingBtn()
        handleMedicineBtn()
        handleDiagnosticBtn()
        handleBack()
        setupDiagnosticPackagesAdapter()
        setupHospitalSpecialitiesAdapter()
        setupPharmacyCategoriesAdapter()
        handleContinueBookingBtn()
        handleAdmitBtn()
    }

    private fun handleAdmitBtn() {
        binding.admitBtn.setOnClickListener { p0 ->
          showAmbulanceBookingBottomSheet(this)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showAmbulanceBookingBottomSheet(context: Context) {
        val bottomSheetDialog = BottomSheetDialog(context)
        val ambulanceBookingBottomSheetBinding = BookAmbulanceBottomSheetBinding.inflate(
            LayoutInflater.from(context))
        bottomSheetDialog.setContentView(ambulanceBookingBottomSheetBinding.root)
        bottomSheetDialog.setOnShowListener { dialog -> val bottomSheet = (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.setBackgroundResource(R.drawable.top_edges_bg)
        }
        ambulanceBookingBottomSheetBinding.crossImg.setOnClickListener(View.OnClickListener {
            bottomSheetDialog.cancel()
            bottomSheetDialog.cancel()
            val intent = Intent(this, HospitalTimeSlotsActivity::class.java)
            intent.putExtra("hospitalId", "hospitalId")
            intent.putExtra("catId", "catId")
            startActivity(intent)
        })

        ambulanceBookingBottomSheetBinding.bookNowBtn.setOnClickListener { p0 ->
            startActivity(Intent(this, AmbulanceBookingSummeryActivity::class.java))
        }

        bottomSheetDialog.show()
    }

    private fun handleContinueBookingBtn() {
        binding.continueBookingBtn.setOnClickListener { p0 ->
            startActivity(Intent(this, HospitalDoctorsActivity::class.java))
        }
    }

    private fun setupPharmacyCategoriesAdapter() {
        val adapter = MedicineCategoriesAdapter()
        val linearLayoutManager = GridLayoutManager(this, 4)
        binding.medicineCategoriesRv.adapter = adapter
        binding.medicineCategoriesRv.layoutManager = linearLayoutManager
    }

    private fun setupHospitalSpecialitiesAdapter() {
        val adapter = OnlineDoctorCategoriesAdapter()
        val linearLayoutManager = GridLayoutManager(this, 4)
        binding.specialitiesRv.adapter = adapter
        binding.specialitiesRv.layoutManager = linearLayoutManager
    }

    private fun setupDiagnosticPackagesAdapter() {
        val adapter = DiagnosticPackagesAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        binding.diagnosticPackagesRv.adapter = adapter
        binding.diagnosticPackagesRv.layoutManager = linearLayoutManager
        adapter.setupListener(object : OnPackageClickListener{
            override fun onIncludedTestsClickListener(position: Int) {
                Log.d("TAG", "onIncludedTestsClickListener: $position")
            }

        })
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { v ->
            finish()
        }
    }

    private fun handleDiagnosticBtn() {
        binding.diagnosticsBtn.setOnClickListener { p0 ->
            setupBtnsStyling(binding.diagnosticsBtn, binding.hospitalBookingBtn, binding.medicinesBtn)
            binding.diagnosticLo.visibility = android.view.View.VISIBLE
            binding.diagnosticContinueLo.visibility = android.view.View.VISIBLE
            binding.pharmacyLo.visibility = android.view.View.GONE
            binding.continueBookingBtn.visibility = android.view.View.GONE
            binding.admitBtn.visibility = android.view.View.GONE
            binding.bookMedicineBtn.visibility = android.view.View.GONE
            binding.hospitalSpecialitiesLo.visibility = android.view.View.GONE

        }
    }

    private fun handleMedicineBtn() {
        binding.medicinesBtn.setOnClickListener { p0 ->
            setupBtnsStyling(binding.medicinesBtn, binding.hospitalBookingBtn, binding.diagnosticsBtn)
            binding.pharmacyLo.visibility = android.view.View.VISIBLE
            binding.bookMedicineBtn.visibility = android.view.View.VISIBLE
            binding.diagnosticLo.visibility = android.view.View.GONE
            binding.continueBookingBtn.visibility = android.view.View.GONE
            binding.admitBtn.visibility = android.view.View.GONE
            binding.hospitalSpecialitiesLo.visibility = android.view.View.GONE
            binding.diagnosticContinueLo.visibility = android.view.View.GONE
        }
    }

    private fun handleHospitalBookingBtn() {
        binding.hospitalBookingBtn.setOnClickListener { p0 ->
            setupBtnsStyling(binding.hospitalBookingBtn, binding.medicinesBtn, binding.diagnosticsBtn)
            binding.hospitalSpecialitiesLo.visibility = android.view.View.VISIBLE
            binding.admitBtn.visibility = android.view.View.VISIBLE
            binding.continueBookingBtn.visibility = android.view.View.VISIBLE
            binding.pharmacyLo.visibility = android.view.View.GONE
            binding.bookMedicineBtn.visibility = android.view.View.GONE
            binding.diagnosticContinueLo.visibility = android.view.View.GONE
            binding.diagnosticLo.visibility = android.view.View.GONE
        }
    }

    private fun setupBtnsStyling(
        textView: TextView,
        textView1: TextView,
        textView2: TextView
    ) {
        textView.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_light_color))
        textView.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))

        textView1.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        textView1.setTextColor(ContextCompat.getColor(this, R.color.black))

        textView2.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        textView2.setTextColor(ContextCompat.getColor(this, R.color.black))
    }

}