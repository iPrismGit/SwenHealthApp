package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.DiagnosticTestBookingDetailsActivity
import com.iprism.swenhealth.adapters.DiagnosticTestBookingsAdapter
import com.iprism.swenhealth.databinding.FragmentDiagnosticTestsOnGoingBookingsBinding
import com.iprism.swenhealth.interfaces.OnBookingItemClickListener

class DiagnosticTestsOnGoingBookingsFragment : Fragment() {

    private lateinit var binding: FragmentDiagnosticTestsOnGoingBookingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiagnosticTestsOnGoingBookingsBinding.inflate(inflater, container, false)
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        val adapter = DiagnosticTestBookingsAdapter()
        binding.bookingsRv.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.bookingsRv.layoutManager = linearLayoutManager
        adapter.setOnBookingItemClickListener(object : OnBookingItemClickListener {
            override fun onItemClicked(id: String, bookingType: String) {
                val intent = Intent(requireContext(), DiagnosticTestBookingDetailsActivity::class.java)
                intent.putExtra("bookingType", "Ongoing")
                startActivity(intent)
            }

        })
    }

}