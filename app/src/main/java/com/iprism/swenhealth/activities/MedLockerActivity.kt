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
import com.iprism.swenhealth.adapters.MedLockerAdapter
import com.iprism.swenhealth.databinding.ActivityMedLockerBinding
import com.iprism.swenhealth.interfaces.OnDocumentItemClickListener

class MedLockerActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMedLockerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMedLockerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        handleAddDocumentsTxt()
        setupMedLocker()
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun handleAddDocumentsTxt() {
        binding.addDocumentsTxt.setOnClickListener(View.OnClickListener {
            val intent =  Intent(this, AddMedLockerDocumentsActivity::class.java)
            startActivity(intent)
        })
    }

    private fun setupMedLocker() {
        val medLockerAdapter = MedLockerAdapter()
        binding.medLockerRv.layoutManager = LinearLayoutManager(this)
        binding.medLockerRv.adapter = medLockerAdapter
        medLockerAdapter.setOnDocumentItemClickListener(object : OnDocumentItemClickListener {
            override fun onItemClicked(position : String) {
           //     if (!medLockerItem.images[0].image.endsWith(".pdf")) {

                    val intent = Intent(this@MedLockerActivity, ViewDocumentsActivity::class.java)
//                    val imageList = ArrayList<String>()
//                    for (item in medLockerItem.images) {
//                        imageList.add(item.image)
//                    }
//                    intent.putStringArrayListExtra("images", imageList)
//                    intent.putExtra("name", medLockerItem.name)
                    startActivity(intent)
              //  }
//                else {
//                    val intent = Intent(this@MedLockerActivity, PdfViewActivity::class.java)
//                    intent.putExtra("pdfUrl", medLockerItem.images[0].image)
//                    intent.putExtra("name", medLockerItem.name)
//                    startActivity(intent)
//                }
            }
        })
    }

}