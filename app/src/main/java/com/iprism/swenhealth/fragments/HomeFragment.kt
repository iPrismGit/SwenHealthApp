package com.iprism.swenhealth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.CategoriesAdapter
import com.iprism.swenhealth.databinding.FragmentHomeBinding
import com.iprism.swenhealth.databinding.FragmentMedicinesBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupDoctorAppointmentsRecyclerView()
        setupDoctorSymptomsRecyclerView()
        setupSurgeonSymptomsRecyclerView()
        setupQuotesRecyclerView()
        setupHomeVisitServicesRecyclerView()
        setupHealthEducationCategoriesRecyclerView()
        return binding.root
    }

    private fun setupQuotesRecyclerView() {
        val adapter = CategoriesAdapter()
        val linearLayout = GridLayoutManager(requireContext(), 4 )
        binding.quotesRv.layoutManager = linearLayout
        binding.quotesRv.adapter = adapter
    }

    private fun setupSurgeonSymptomsRecyclerView() {
        val adapter = CategoriesAdapter()
        val linearLayout = GridLayoutManager(requireContext(), 4 )
        binding.surgeonSymptomsRv.layoutManager = linearLayout
        binding.surgeonSymptomsRv.adapter = adapter
    }

    private fun setupHealthEducationCategoriesRecyclerView() {
        val adapter = CategoriesAdapter()
        val linearLayout = GridLayoutManager(requireContext(), 4 )
        binding.healthEducationCategoriesRv.layoutManager = linearLayout
        binding.healthEducationCategoriesRv.adapter = adapter
    }

    private fun setupHomeVisitServicesRecyclerView() {
        val adapter = CategoriesAdapter()
        val linearLayout = GridLayoutManager(requireContext(), 4 )
        binding.homeVisitServicesRv.layoutManager = linearLayout
        binding.homeVisitServicesRv.adapter = adapter
    }

    private fun setupDoctorSymptomsRecyclerView() {
        val adapter = CategoriesAdapter()
        val linearLayout = GridLayoutManager(requireContext(), 4 )
        binding.doctorSymptomsRv.layoutManager = linearLayout
        binding.doctorSymptomsRv.adapter = adapter
    }

    private fun setupDoctorAppointmentsRecyclerView() {
        val adapter = CategoriesAdapter()
        val linearLayout = GridLayoutManager(requireContext(), 4 )
        binding.doctorAppointmentsRv.layoutManager = linearLayout
        binding.doctorAppointmentsRv.adapter = adapter
    }

}