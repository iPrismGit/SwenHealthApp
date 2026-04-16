package com.iprism.swenhealth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.activities.DiagnosticPackagesActivity
import com.iprism.swenhealth.activities.DiagnosticSummeryActivity
import com.iprism.swenhealth.adapters.DiagnosticsAndLabsAdapter
import com.iprism.swenhealth.databinding.ActivityMainBinding
import com.iprism.swenhealth.databinding.FragmentDiagnosticBinding
import com.iprism.swenhealth.interfaces.OnHospitalClickListener

class DiagnosticFragment : Fragment() {

    private lateinit var binding: FragmentDiagnosticBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiagnosticBinding.inflate(inflater, container, false)
        setupAdapter()
        handleCart()
        return binding.root
    }

    private fun handleCart() {
        binding.cartImg.setOnClickListener { p0 ->
            startActivity(Intent(requireContext(), DiagnosticSummeryActivity::class.java))
        }
    }

    private fun setupAdapter() {
        val adapter = DiagnosticsAndLabsAdapter()
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.labsRv.adapter = adapter
        binding.labsRv.layoutManager = linearLayoutManager
        adapter.setupListener(object : OnHospitalClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(requireContext(), DiagnosticPackagesActivity::class.java)
                startActivity(intent)
            }

        })
    }

}