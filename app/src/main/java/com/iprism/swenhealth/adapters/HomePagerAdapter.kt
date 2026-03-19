package com.iprism.swenhealth.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iprism.swenhealth.fragments.DiagnosticFragment
import com.iprism.swenhealth.fragments.HomeFragment
import com.iprism.swenhealth.fragments.HospitalsFragment
import com.iprism.swenhealth.fragments.LabTestFragment
import com.iprism.swenhealth.fragments.MedicinesFragment

class HomePagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(p0: Int): Fragment {
        return when (p0) {
            0 -> HomeFragment()
            1 -> HospitalsFragment()
            2 -> MedicinesFragment()
            3 -> LabTestFragment()
            4 -> DiagnosticFragment()
            else -> HomeFragment()
        }
    }

    override fun getItemCount(): Int {
        return 5
    }

}