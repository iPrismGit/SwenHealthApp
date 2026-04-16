package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.MedicineCartActivity
import com.iprism.swenhealth.adapters.HomePagerAdapter
import com.iprism.swenhealth.adapters.MedicinesPagerAdapter
import com.iprism.swenhealth.databinding.FragmentMedicinesBinding


class MedicinesFragment : Fragment() {

    private lateinit var binding: FragmentMedicinesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMedicinesBinding.inflate(inflater, container, false)
        setupViewPager()
        handleWellnessBtn()
        handlePharmacyBtn()
        handleCartBtn()
        return binding.root
    }

    private fun handleCartBtn() {
        binding.cartIv.setOnClickListener { p0 ->
            startActivity(Intent(requireContext(), MedicineCartActivity::class.java))
        }
    }

    private fun handleWellnessBtn() {
        binding.wellnessBtn.setOnClickListener { p0 ->
            setupButtonsStyling(binding.wellnessBtn, binding.pharmacyBtn)
            binding.viewpager.setCurrentItem(0, false)
        }
    }

    private fun handlePharmacyBtn() {
        binding.pharmacyBtn.setOnClickListener { p0 ->
            setupButtonsStyling(binding.pharmacyBtn, binding.wellnessBtn)
            binding.viewpager.setCurrentItem(1, false)
        }
    }

    private fun setupButtonsStyling(textView: TextView, textView1: TextView){
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
        textView.background = ContextCompat.getDrawable(requireContext(), R.drawable.selected_curved_btn_bg)
        textView1.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        textView1.background = ContextCompat.getDrawable(requireContext(), R.drawable.un_selected_curved_btn_bg)
    }

    private fun setupViewPager() {
        val adapter = MedicinesPagerAdapter(this)
        binding.viewpager.isUserInputEnabled = false
        binding.viewpager.adapter = adapter
        setupButtonsStyling(binding.wellnessBtn, binding.pharmacyBtn)
    }

}