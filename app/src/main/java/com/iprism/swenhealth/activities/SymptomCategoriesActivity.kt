package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.SymptomCategoriesAdapter
import com.iprism.swenhealth.databinding.ActivitySymptomCategoriesBinding
import com.iprism.swenhealth.interfaces.OnServiceItemClickListener

class SymptomCategoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySymptomCategoriesBinding
    private var tag = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySymptomCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        intent.getStringExtra("tag").toString()
        if (tag.equals("symptoms", true)){
            binding.titleTxt.text = "Book Doctor With Symptoms"
        }else{
            binding.titleTxt.text = "Choose Surgeon With Symptoms"
        }
        handleBack()
        setupAdapter()
    }

    private fun setupAdapter() {
        val adapter = SymptomCategoriesAdapter()
        binding.categoriesRv.adapter = adapter
        val linearLayoutManager = GridLayoutManager(this, 4)
        binding.categoriesRv.layoutManager = linearLayoutManager
        adapter.setupListener(object  : OnServiceItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@SymptomCategoriesActivity, HospitalDoctorsActivity::class.java)
                startActivity(intent)
            }
        })
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }

}