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
import com.iprism.swenhealth.databinding.FragmentAmbulanceOnGoingBookingsBinding
import com.iprism.swenhealth.interfaces.OnAmbulanceBookingItemClickListener

class AmbulanceOnGoingBookingsFragment : Fragment() {

    private lateinit var binding: FragmentAmbulanceOnGoingBookingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAmbulanceOnGoingBookingsBinding.inflate(inflater, container, false)
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
                intent.putExtra("bookingStatus", "Ongoing")
                startActivity(intent)
            }

            override fun onCallClicked(mobile: String) {

            }

            override fun onTrackClicked(details: String) {

            }

        })
    }

}