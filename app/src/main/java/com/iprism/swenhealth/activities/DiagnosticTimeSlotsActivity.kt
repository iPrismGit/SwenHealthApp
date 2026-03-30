package com.iprism.swenhealth.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.DatesAdapter
import com.iprism.swenhealth.interfaces.OnSlotItemClickListener
import com.iprism.swenhealth.adapters.TestsAdapter
import com.iprism.swenhealth.adapters.TimeSlotsAdapter
import com.iprism.swenhealth.databinding.ActivityDiagnosticTimeSlotsBinding
import com.iprism.swenhealth.databinding.FamilyMembersBottomSheetBinding
import com.iprism.swenhealth.databinding.TestsBottomSheetBinding
import com.iprism.swenhealth.interfaces.OnDateClickListener

class DiagnosticTimeSlotsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnosticTimeSlotsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDiagnosticTimeSlotsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupDatesAdapter()
        setupMorningTimesAdapter()
        setupAfternoonTimesAdapter()
        setupEveningTimesAdapter()
        handleContinueBtn()
    }

    private fun handleContinueBtn() {
       binding.continueBookingBtn.setOnClickListener { p0 ->
           showMembersSelectionBottomSheet()
       }
    }

    @SuppressLint("SetTextI18n")
    private fun showMembersSelectionBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val testsBottomSheetBinding = FamilyMembersBottomSheetBinding.inflate(LayoutInflater.from(this))
        bottomSheetDialog.setContentView(testsBottomSheetBinding.root)
        bottomSheetDialog.setOnShowListener { dialog ->
            val bottomSheet =
                (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.setBackgroundResource(R.drawable.top_edges_bg)
        }
        testsBottomSheetBinding.crossIv.setOnClickListener(View.OnClickListener {
            bottomSheetDialog.cancel()
        })
       testsBottomSheetBinding.continueBookingBtn.setOnClickListener { p0 ->
           startActivity(Intent(this, AddMultiPatientsActivity::class.java))
       }
        bottomSheetDialog.show()
    }

    private fun setupMorningTimesAdapter() {
        val adapter = TimeSlotsAdapter()
        val linearLayoutManager = GridLayoutManager(this, 3)
        binding.morningTimesRv.adapter = adapter
        binding.morningTimesRv.layoutManager = linearLayoutManager
        adapter.setOnItemClickListener(object  : OnSlotItemClickListener{
            override fun onItemClick(time: String, id: String) {
                Log.d("Time", time)
            }

        })
    }

    private fun setupAfternoonTimesAdapter() {
        val adapter = TimeSlotsAdapter()
        val linearLayoutManager = GridLayoutManager(this, 3)
        binding.afternoonTimesRv.adapter = adapter
        binding.afternoonTimesRv.layoutManager = linearLayoutManager
        adapter.setOnItemClickListener(object  : OnSlotItemClickListener{
            override fun onItemClick(time: String, id: String) {
                Log.d("Time", time)
            }

        })
    }

    private fun setupEveningTimesAdapter() {
        val adapter = TimeSlotsAdapter()
        val linearLayoutManager = GridLayoutManager(this, 3)
        binding.eveningTimesRv.adapter = adapter
        binding.eveningTimesRv.layoutManager = linearLayoutManager
        adapter.setOnItemClickListener(object  : OnSlotItemClickListener{
            override fun onItemClick(time: String, id: String) {
                Log.d("Time", time)
            }

        })
    }

    private fun setupDatesAdapter() {
        val adapter = DatesAdapter()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.selectDatesRv.adapter = adapter
        binding.selectDatesRv.layoutManager = layoutManager
        adapter.setupListener(object : OnDateClickListener{
            override fun onItemClick(date: String) {
                Log.d("Date", date)
            }

        })
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }

}