package com.iprism.swenhealth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.FragmentWellnessProductsBinding
import com.iprism.swenhealth.databinding.ServiceItemBinding


class WellnessProductsFragment : Fragment() {

    private lateinit var binding: FragmentWellnessProductsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWellnessProductsBinding.inflate(inflater, container, false)
        return binding.root
    }


}