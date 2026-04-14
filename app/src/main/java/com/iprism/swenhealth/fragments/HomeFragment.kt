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
import com.iprism.swenhealth.activities.HealthMediaActivity
import com.iprism.swenhealth.activities.HospitalDoctorsActivity
import com.iprism.swenhealth.activities.MainActivity
import com.iprism.swenhealth.activities.NotificationsActivity
import com.iprism.swenhealth.activities.OnlineDoctorCategoriesActivity
import com.iprism.swenhealth.activities.RedeemDiscountCouponsActivity
import com.iprism.swenhealth.activities.SymptomCategoriesActivity
import com.iprism.swenhealth.activities.TestimonialVideosActivity
import com.iprism.swenhealth.adapters.CategoriesAdapter
import com.iprism.swenhealth.databinding.FragmentHomeBinding
import com.iprism.swenhealth.databinding.FragmentMedicinesBinding
import com.iprism.swenhealth.interfaces.OnServiceItemClickListener
import com.iprism.swenhealth.utils.ToastUtils

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
        handleRedeemCouponsLo()
        handleOnlineDoctorLo()
        handleBookAmbulance()
        handleHospitalAdmission()
        handleMenuImg()
        handleNotificationImg()
        handleBookDiagnosticTestImg()
        handleHealthMediaLo()
        handleHealthTalksLo()
        handleDietTipsLo()
        handleSymptomCheckerLo()
        handleWhatsappAssistanceLo()
        handleHealthInsAdmissionLo()
        handleFreeVideoConsultationLo()
        return binding.root
    }

    private fun handleFreeVideoConsultationLo() {
        binding.freeVideoConLo.setOnClickListener { p0 ->
            ToastUtils.showErrorCustomToast(requireContext(), "No Screens..!")
        }
    }

    private fun handleHealthInsAdmissionLo() {
        binding.healthInsAdmissionsLo.setOnClickListener { p0 ->
            ToastUtils.showErrorCustomToast(requireContext(), "No Screens..!")
        }
    }

    private fun handleWhatsappAssistanceLo() {
        binding.whatsappAssistLo.setOnClickListener { p0 ->
            ToastUtils.showErrorCustomToast(requireContext(), "No Screens..!")
        }
    }

    private fun handleDietTipsLo() {
        binding.dietTipsLo.setOnClickListener { p0 ->
            ToastUtils.showErrorCustomToast(requireContext(), "No Screens..!")
        }
    }

    private fun handleSymptomCheckerLo() {
        binding.symptomCheckerLo.setOnClickListener { p0 ->
            ToastUtils.showErrorCustomToast(requireContext(), "No Screens..!")
        }
    }

    private fun handleHealthTalksLo() {
        binding.healthTalksLo.setOnClickListener { p0 ->
            startActivity(Intent(requireContext(), TestimonialVideosActivity::class.java))
        }
    }

    private fun handleHealthMediaLo() {
        binding.healthMediaLo.setOnClickListener { p0 ->
            startActivity(Intent(requireContext(), HealthMediaActivity::class.java))
        }
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

    private fun handleBookDiagnosticTestImg() {
        binding.diagnosticTestBtn.setOnClickListener { p0 ->
            (activity as? MainActivity)?.changeFragment(4)
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
        adapter.setupListener(object : OnServiceItemClickListener{
            override fun onItemClick(position: Int) {
                ToastUtils.showErrorCustomToast(requireContext(), "No Screens in Figma..!")
            }

        })
    }

    private fun setupSurgeonSymptomsRecyclerView() {
        val adapter = CategoriesAdapter()
        val linearLayout = GridLayoutManager(requireContext(), 4 )
        binding.surgeonSymptomsRv.layoutManager = linearLayout
        binding.surgeonSymptomsRv.adapter = adapter
        adapter.setupListener(object : OnServiceItemClickListener{
            override fun onItemClick(position: Int) {
                if (position == 3){
                    val intent = Intent(requireContext(), SymptomCategoriesActivity::class.java)
                    intent.putExtra("tag", "Surgeon")
                    startActivity(intent)
                } else{
                    val intent = Intent(requireContext(), HospitalDoctorsActivity::class.java)
                    intent.putExtra("fragment", "Hospitals")
                    startActivity(intent)
                }

            }

        })
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
        adapter.setupListener(object : OnServiceItemClickListener{
            override fun onItemClick(position: Int) {
                if (position == 3){
                    val intent = Intent(requireContext(), SymptomCategoriesActivity::class.java)
                    intent.putExtra("tag", "Symptoms")
                    startActivity(intent)
                } else{
                    val intent = Intent(requireContext(), HospitalDoctorsActivity::class.java)
                    intent.putExtra("fragment", "Hospitals")
                    startActivity(intent)
                }

            }

        })
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
                    (activity as? MainActivity)?.changeFragment(1)
                }

            }

        })
    }

}