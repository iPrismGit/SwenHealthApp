package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.HospitalDetailsActivity
import com.iprism.swenhealth.adapters.HospitalsAdapter
import com.iprism.swenhealth.databinding.FragmentHospitalsBinding
import com.iprism.swenhealth.databinding.FragmentMedicinesBinding
import com.iprism.swenhealth.interfaces.OnHospitalClickListener

class HospitalsFragment : Fragment() {

    private lateinit var binding: FragmentHospitalsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHospitalsBinding.inflate(inflater, container, false)
        setupHospitalAdapter()
        return binding.root
    }

    private fun setupHospitalAdapter() {
        val adapter = HospitalsAdapter()
        val linearLayout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.hospitalsRv.layoutManager = linearLayout
        binding.hospitalsRv.adapter = adapter
        adapter.setupListener(object : OnHospitalClickListener{
            override fun onItemClick(position: Int) {
                startActivity(Intent(requireContext(), HospitalDetailsActivity::class.java))
            }

        })
    }

}