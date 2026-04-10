package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.DoctorAppointmentCategoriesActivity
import com.iprism.swenhealth.activities.MainActivity
import com.iprism.swenhealth.activities.NotificationsActivity
import com.iprism.swenhealth.activities.OnlineDoctorCategoriesActivity
import com.iprism.swenhealth.activities.RedeemDiscountCouponsActivity
import com.iprism.swenhealth.adapters.CategoriesAdapter
import com.iprism.swenhealth.databinding.FragmentHomeBinding
import com.iprism.swenhealth.databinding.FragmentMedicinesBinding
import com.iprism.swenhealth.interfaces.OnServiceItemClickListener

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
        handleRedeemCouponsLo()
        handleOnlineDoctorLo()
        handleBookAmbulance()
        handleHospitalAdmission()
        handleMenuImg()
        handleNotificationImg()
        return binding.root
    }

    private fun handleNotificationImg() {
        binding.notificationImg.setOnClickListener { p0 ->
            startActivity(Intent(requireContext(), NotificationsActivity::class.java))
        }
    }

    private fun handleMenuImg() {
        binding.menuImg.setOnClickListener { p0 ->
            (activity as? MainActivity)?.showMenuBottomSheet()
        }
    }

    private fun handleHospitalAdmission() {
        binding.referAnAdmissionLo.setOnClickListener { p0 ->
            (activity as? MainActivity)?.changeFragment(1)
        }
    }

    private fun handleBookAmbulance() {
        binding.requestAmbulanceLo.setOnClickListener { p0 ->
            (activity as? MainActivity)?.changeFragment(1)
        }
    }

    private fun handleOnlineDoctorLo() {
        binding.onlineDoctorLo.setOnClickListener { p0 ->
            startActivity(Intent(requireContext(), OnlineDoctorCategoriesActivity::class.java))
        }
    }

    private fun handleRedeemCouponsLo() {
        binding.redeemCouponsLo.setOnClickListener { v ->
            startActivity(Intent(requireContext(), RedeemDiscountCouponsActivity::class.java))
        }
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
        adapter.setupListener(object : OnServiceItemClickListener{
            override fun onItemClick(position: Int) {
                if (position == 3){
                    val intent = Intent(requireContext(), DoctorAppointmentCategoriesActivity::class.java)
                    startActivity(intent)
                } else{
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    intent.putExtra("fragment", "Hospitals")
                    startActivity(intent)
                }

            }

        })
    }

}