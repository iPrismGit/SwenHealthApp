package com.iprism.swenhealth.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.FilterCatsAdapter
import com.iprism.swenhealth.adapters.FilterSubCatsAdapter
import com.iprism.swenhealth.databinding.ActivityFilterBinding
import com.iprism.swenhealth.interfaces.OnFilterCatItemClickListener
import com.iprism.swenhealth.interfaces.OnFilterSpecialityItemActionListener
import com.iprism.swenhealth.utils.ToastUtils

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupAdapter()
        setupSubCatsAdapter()
        handleApplyFilterBtn()
        handleResetBtn()
    }

    private fun handleResetBtn() {
        binding.resetBtn.setOnClickListener { p0 ->
            ToastUtils.showSuccessCustomToast(this, "Filter Reset")
        }
    }

    private fun handleApplyFilterBtn() {
        binding.applyFilterBtn.setOnClickListener { p0 ->
            ToastUtils.showSuccessCustomToast(this, "Filter Applied")
            finish()
        }
    }

    private fun setupSubCatsAdapter() {
        val adapter = FilterSubCatsAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.filterSubCatsRv.adapter = adapter
        binding.filterSubCatsRv.layoutManager = layoutManager
        adapter.setListener(object : OnFilterSpecialityItemActionListener{
            override fun onFilterValueClicked(position: Int) {
                Log.d("TAG", "onFilterValueClicked: $position")
            }
        })

    }

    private fun setupAdapter() {
        val adapter = FilterCatsAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.filterCatsRv.adapter = adapter
        binding.filterCatsRv.layoutManager = layoutManager
        adapter.setListener(object : OnFilterCatItemClickListener{
            override fun onItemClicked(position: String) {
                Log.d("TAG", "onItemClicked: $position")
            }

        })
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }
}