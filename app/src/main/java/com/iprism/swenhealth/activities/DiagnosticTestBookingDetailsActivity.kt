package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityDiagnosticTestBookingDetailsBinding

class DiagnosticTestBookingDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnosticTestBookingDetailsBinding
    private var bookingType = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDiagnosticTestBookingDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        bookingType = intent.getStringExtra("bookingType").toString()
        handleBack()
        handleViewPrescriptionLL()
        handlePrescriptionLL()
        setupUi()
    }

    private fun handleViewPrescriptionLL() {
        binding.viewPrescriptionLl.setOnClickListener { p0 ->
            val intent = Intent(this, ViewDocumentsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun handlePrescriptionLL() {
        binding.prescriptionLl.setOnClickListener(View.OnClickListener {
//            if (!image.endsWith(".pdf")) {
            val intent = Intent(this, ViewDocumentsActivity::class.java)
//                val imageList = ArrayList<String>()
//                imageList.add(image)
//                intent.putStringArrayListExtra("images", imageList)
//                intent.putExtra("name", getString(R.string.prescription))
            startActivity(intent)
//            } else {
//                val intent = Intent(this, PdfViewActivity::class.java)
//                intent.putExtra("pdfUrl", image)
//                intent.putExtra("name", getString(R.string.prescription))
//                startActivity(intent)
//            }
        })
    }

    private fun setupUi() {
        if (bookingType.equals("Ongoing", true)){
            binding.progressLine.setBackgroundColor(ContextCompat.getColor(this, R.color.gray5))
            binding.progressLine2.setBackgroundColor(ContextCompat.getColor(this, R.color.gray5))
            binding.stepPlaced.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepProcessed.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.grey_img))
            binding.stepCompleted.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.grey_img))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelProcessed.setTextColor(ContextCompat.getColor(this, R.color.thick_gray1))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.thick_gray1))
            binding.viewPrescriptionLl.visibility = View.GONE

        } else{
            binding.progressLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.progressLine2.setBackgroundColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.stepPlaced.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepProcessed.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.stepCompleted.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blue_img))
            binding.labelPlaced.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelProcessed.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.labelCompleted.setTextColor(ContextCompat.getColor(this, R.color.app_primary_color))
            binding.viewPrescriptionLl.visibility = View.VISIBLE
        }
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener { p0 ->
            finish()
        }
    }

}