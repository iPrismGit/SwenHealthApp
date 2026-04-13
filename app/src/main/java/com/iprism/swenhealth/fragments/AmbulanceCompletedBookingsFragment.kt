package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.HospitalAmbulanceBookingDetailsActivity
import com.iprism.swenhealth.adapters.HospitalAmbulanceBookingsAdapter
import com.iprism.swenhealth.databinding.ActivityAddAdmitPatientBinding
import com.iprism.swenhealth.databinding.FragmentAmbulanceCompletedBookingsBinding
import com.iprism.swenhealth.interfaces.OnAmbulanceBookingItemClickListener

class AmbulanceCompletedBookingsFragment : Fragment() {

    private lateinit var binding: FragmentAmbulanceCompletedBookingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAmbulanceCompletedBookingsBinding.inflate(inflater, container, false)
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        val adapter = HospitalAmbulanceBookingsAdapter()
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.bookingsRv.layoutManager = linearLayoutManager
        binding.bookingsRv.adapter = adapter
        adapter.setupListener(object : OnAmbulanceBookingItemClickListener {
            override fun onItemClicked(details: String) {
                val intent = Intent(requireContext(), HospitalAmbulanceBookingDetailsActivity::class.java)
                intent.putExtra("bookingStatus", "Completed")
                startActivity(intent)
            }

            override fun onCallClicked(mobile: String) {

            }

            override fun onTrackClicked(details: String) {

            }

        })
    }

}