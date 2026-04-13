package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.HospitalAdmissionBookingDetailsActivity
import com.iprism.swenhealth.adapters.HospitalAdmissionBookingsAdapter
import com.iprism.swenhealth.databinding.FragmentHospitalAdmissionOnGoingBinding
import com.iprism.swenhealth.interfaces.OnHospitalAdmitBookingItemClickListener

class HospitalAdmissionOnGoingFragment : Fragment() {

    private lateinit var binding: FragmentHospitalAdmissionOnGoingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHospitalAdmissionOnGoingBinding.inflate(inflater, container, false)
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        val adapter = HospitalAdmissionBookingsAdapter()
        binding.bookingsRv.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.bookingsRv.layoutManager = linearLayoutManager
        adapter.setupListener(object : OnHospitalAdmitBookingItemClickListener{
            override fun onItemClicked(id: String, bookingType: String) {
                val intent = Intent(requireContext(), HospitalAdmissionBookingDetailsActivity::class.java)
                intent.putExtra("bookingStatus", "Ongoing")
                startActivity(intent)
            }

            override fun onCallClicked(mobile: String) {

            }

        })
    }

}