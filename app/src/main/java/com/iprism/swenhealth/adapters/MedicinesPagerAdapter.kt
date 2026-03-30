package com.iprism.swenhealth.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iprism.swenhealth.fragments.DiagnosticFragment
import com.iprism.swenhealth.fragments.HomeFragment
import com.iprism.swenhealth.fragments.HospitalsFragment
import com.iprism.swenhealth.fragments.LabTestFragment
import com.iprism.swenhealth.fragments.MedicinesFragment
import com.iprism.swenhealth.fragments.PharmacyFragment
import com.iprism.swenhealth.fragments.WellnessProductsFragment

class MedicinesPagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(p0: Int): Fragment {
        return when (p0) {
            0 -> WellnessProductsFragment()
            1 -> PharmacyFragment()
            else -> WellnessProductsFragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}