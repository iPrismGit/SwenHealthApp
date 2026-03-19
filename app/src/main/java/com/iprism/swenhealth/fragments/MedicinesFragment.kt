package com.iprism.swenhealth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.FragmentMedicinesBinding


class MedicinesFragment : Fragment() {

    private lateinit var binding: FragmentMedicinesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMedicinesBinding.inflate(inflater, container, false)
        return binding.root
    }

}