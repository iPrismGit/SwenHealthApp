package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.MultiFamilyMembersAdapter
import com.iprism.swenhealth.databinding.ActivityAddAdmitPatientBinding
import com.iprism.swenhealth.interfaces.OnMultipleFamilyItemClickListener

class AddAdmitPatientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddAdmitPatientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddAdmitPatientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setUpFamilyMembers()
        handleConfirmBtn()
    }

    private fun handleConfirmBtn() {
        binding.continueBookingBtn.setOnClickListener { p0 ->
            var intent = Intent(this, SuccessActivity::class.java)
            intent.putExtra("tag", "Patient Admitted")
            startActivity(intent)
        }
    }

    private fun setUpFamilyMembers() {
        val familyMembersAdapter = MultiFamilyMembersAdapter()
        binding.familyMembersRv.layoutManager = GridLayoutManager(this, 3)
        binding.familyMembersRv.adapter = familyMembersAdapter
        familyMembersAdapter.setOnMultipleFamilyItemClickListener(object :
            OnMultipleFamilyItemClickListener {
            override fun onItemClicked(position: String) {
                Log.d("Position", position)
            }
        })
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }


}