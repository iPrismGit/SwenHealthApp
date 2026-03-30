package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.PharmacyMedicineCategoriesActivity
import com.iprism.swenhealth.adapters.PharmaciesAdapter
import com.iprism.swenhealth.databinding.FragmentPharmacyBinding
import com.iprism.swenhealth.databinding.ServiceItemBinding
import com.iprism.swenhealth.interfaces.OnHospitalClickListener


class PharmacyFragment : Fragment() {

    private lateinit var binding: FragmentPharmacyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPharmacyBinding.inflate(inflater, container, false)
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        val adapter = PharmaciesAdapter()
        val linearLayout = LinearLayoutManager(requireContext())
        binding.pharmaciesRv.layoutManager = linearLayout
        binding.pharmaciesRv.adapter = adapter
        adapter.setupListener(object : OnHospitalClickListener{
            override fun onItemClick(position: Int) {
                startActivity(Intent(requireContext(), PharmacyMedicineCategoriesActivity::class.java))
            }

        })

    }

}