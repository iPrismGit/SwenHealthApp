package com.iprism.swenhealth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityMainBinding
import com.iprism.swenhealth.databinding.FragmentLabTestBinding

class LabTestFragment : Fragment() {

    private lateinit var binding: FragmentLabTestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLabTestBinding.inflate(inflater, container, false)
        return binding.root
    }

}