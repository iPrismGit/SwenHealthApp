package com.iprism.swenhealth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.FragmentHospitalsBinding
import com.iprism.swenhealth.databinding.FragmentMedicinesBinding

class HospitalsFragment : Fragment() {

    private lateinit var binding: FragmentHospitalsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHospitalsBinding.inflate(inflater, container, false)
        return binding.root
    }

}