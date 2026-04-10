package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.LabTestBookingDetailsActivity
import com.iprism.swenhealth.adapters.LabTestBookingsAdapter
import com.iprism.swenhealth.databinding.FragmentLabTestsCompletedBookingsBinding
import com.iprism.swenhealth.interfaces.OnBookingItemClickListener


class LabTestsCompletedBookingsFragment : Fragment() {

    private lateinit var binding: FragmentLabTestsCompletedBookingsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLabTestsCompletedBookingsBinding.inflate(inflater, container, false)
        setupLabTestBookingsAdapter()
        return binding.root
    }

    private fun setupLabTestBookingsAdapter() {
        val adapter = LabTestBookingsAdapter()
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.bookingsRv.adapter = adapter
        binding.bookingsRv.layoutManager = linearLayoutManager
        adapter.setupListener(object : OnBookingItemClickListener{
            override fun onItemClicked(id: String, bookingType: String) {
                val intent = Intent(requireContext(), LabTestBookingDetailsActivity::class.java)
                intent.putExtra("id", id)
                intent.putExtra("bookingType", "Completed")
                startActivity(intent)
            }

        })
    }

}