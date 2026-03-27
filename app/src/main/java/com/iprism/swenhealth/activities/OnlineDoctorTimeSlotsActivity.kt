package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.DatesAdapter
import com.iprism.swenhealth.adapters.OnSlotItemClickListener
import com.iprism.swenhealth.adapters.TimeSlotsAdapter
import com.iprism.swenhealth.databinding.ActivityOnlineDoctorProfileBinding
import com.iprism.swenhealth.databinding.ActivityOnlineDoctorTimeSlotsBinding
import com.iprism.swenhealth.interfaces.OnDateClickListener

class OnlineDoctorTimeSlotsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnlineDoctorTimeSlotsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOnlineDoctorTimeSlotsBinding.inflate(layoutInflater)
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
        binding.continueBtn.setOnClickListener { p0 ->
            startActivity(Intent(this, AddOnlineDoctorPatientDetailsActivity::class.java))
        }
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
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
}