package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.PharmacyProductsActivity
import com.iprism.swenhealth.adapters.MedicineCategoriesAdapter
import com.iprism.swenhealth.databinding.FragmentWellnessProductsBinding
import com.iprism.swenhealth.databinding.ServiceItemBinding
import com.iprism.swenhealth.interfaces.OnServiceItemClickListener


class WellnessProductsFragment : Fragment() {

    private lateinit var binding: FragmentWellnessProductsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWellnessProductsBinding.inflate(inflater, container, false)
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        val adapter = MedicineCategoriesAdapter()
        val linearLayoutManager = GridLayoutManager(requireContext(), 4)
        binding.categoriesRv.layoutManager = linearLayoutManager
        binding.categoriesRv.adapter = adapter
        adapter.setupListener(object : OnServiceItemClickListener{
            override fun onItemClick(position: Int) {
                startActivity(Intent(requireContext(), PharmacyProductsActivity::class.java))
            }

        })
    }


}