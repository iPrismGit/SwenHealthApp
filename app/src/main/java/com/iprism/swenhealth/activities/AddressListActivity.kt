package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.AddressListAdapter
import com.iprism.swenhealth.databinding.ActivityAddressListBinding

class AddressListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddressListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddressListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupAdapter()
        handleAddNewAddrresBtn()
    }

    private fun setupAdapter() {
        val adapter = AddressListAdapter()
        val linearLayout = LinearLayoutManager(this)
        binding.addressListRv.layoutManager = linearLayout
        binding.addressListRv.adapter = adapter
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }

    private fun handleAddNewAddrresBtn() {
        binding.addNewAddressBtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, AddressActivity::class.java))
        })
    }

}