package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.PharmacyBookingDetailsActivity
import com.iprism.swenhealth.adapters.MedicineBookingsAdapter
import com.iprism.swenhealth.databinding.FragmentOnlineDoctorCompletedBookingsBinding
import com.iprism.swenhealth.databinding.FragmentPharmacyCompletedBookingsBinding
import com.iprism.swenhealth.databinding.FragmentPharmacyOnGoingBookingsBinding
import com.iprism.swenhealth.interfaces.OnBookingItemClickListener

class PharmacyOnGoingBookingsFragment : Fragment() {

    private lateinit var binding: FragmentPharmacyOnGoingBookingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPharmacyOnGoingBookingsBinding.inflate(inflater, container, false)
        setupAdapter()
        return binding.root
    }


    private fun setupAdapter() {
        val adapter = MedicineBookingsAdapter()
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.bookingsRv.layoutManager = linearLayoutManager
        binding.bookingsRv.adapter = adapter
        adapter.setupListener(object : OnBookingItemClickListener {
            override fun onItemClicked(id: String, bookingType: String) {
                val intent = Intent(requireContext(), PharmacyBookingDetailsActivity::class.java)
                intent.putExtra("booking_id", id)
                intent.putExtra("bookingType", "Ongoing")
                startActivity(intent)
            }
        })
    }

}