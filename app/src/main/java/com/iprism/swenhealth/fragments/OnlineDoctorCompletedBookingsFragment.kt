package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.DoctorBookingDetailsActivity
import com.iprism.swenhealth.adapters.OnlineDoctorBookingsAdapter
import com.iprism.swenhealth.databinding.FragmentOnlineDoctorCompletedBookingsBinding
import com.iprism.swenhealth.interfaces.OnOnlineDoctorBookingItemClickListener

class OnlineDoctorCompletedBookingsFragment : Fragment() {

    private lateinit var binding: FragmentOnlineDoctorCompletedBookingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentOnlineDoctorCompletedBookingsBinding.inflate(layoutInflater)
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        val  adapter = OnlineDoctorBookingsAdapter()
        binding.bookingsRv.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.bookingsRv.layoutManager = linearLayoutManager
        adapter.setupListener(object  : OnOnlineDoctorBookingItemClickListener{
            override fun onItemClicked(bookingId: String) {
                val intent = Intent(requireContext(), DoctorBookingDetailsActivity::class.java)
                intent.putExtra("bookingId", bookingId)
                intent.putExtra("bookingStatus", "Completed")
                startActivity(intent)
            }

        })
    }

}