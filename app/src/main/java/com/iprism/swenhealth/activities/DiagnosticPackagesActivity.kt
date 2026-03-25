package com.iprism.swenhealth.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.DiagnosticPackagesAdapter
import com.iprism.swenhealth.adapters.TestsAdapter
import com.iprism.swenhealth.databinding.ActivityDiagnosticPackagesBinding
import com.iprism.swenhealth.databinding.TestsBottomSheetBinding
import com.iprism.swenhealth.interfaces.OnPackageClickListener

class DiagnosticPackagesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnosticPackagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDiagnosticPackagesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupAdapter()
        handleContinueBtn()
    }

    private fun handleContinueBtn() {
        binding.continueBtn.setOnClickListener { p0 ->
            startActivity(Intent(this, DiagnosticTimeSlotsActivity::class.java))
        }
    }

    private fun setupAdapter() {
        val adapter = DiagnosticPackagesAdapter()
        val linearLayout = LinearLayoutManager(this)
        binding.diagnosticPackagesRv.adapter = adapter
        binding.diagnosticPackagesRv.layoutManager = linearLayout
        adapter.setupListener(object : OnPackageClickListener{
            override fun onIncludedTestsClickListener(position: Int) {
               showTestsSheet()
            }

        })
    }

    @SuppressLint("SetTextI18n")
    private fun showTestsSheet() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val testsBottomSheetBinding = TestsBottomSheetBinding.inflate(LayoutInflater.from(this))
        bottomSheetDialog.setContentView(testsBottomSheetBinding.root)
        bottomSheetDialog.setOnShowListener { dialog ->
            val bottomSheet =
                (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.setBackgroundResource(R.drawable.top_edges_bg)
        }
        testsBottomSheetBinding.crossImg.setOnClickListener(View.OnClickListener {
            bottomSheetDialog.cancel()
        })
        testsBottomSheetBinding.numberOfTestsTxt.text = "Contains 34 Tests"
        val testsAdapter = TestsAdapter()
        testsBottomSheetBinding.testsRv.layoutManager = LinearLayoutManager(this)
        testsBottomSheetBinding.testsRv.adapter = testsAdapter
        bottomSheetDialog.show()
    }

    private fun handleBack() {
       binding.backImg.setOnClickListener { v ->
           finish()
       }
    }

}