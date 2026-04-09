package com.iprism.swenhealth.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityAboutUsBinding

class AboutUsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutUsBinding
    private var tag : String = ""
    private var name : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        handleAboutUs()
        handlePrivacy()
        handleTerms()
    }

    private fun handleBack() {
        binding.backIv.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun handleAboutUs() {
        binding.aboutUsTxt.setOnClickListener(View.OnClickListener {
            tag = "about_us"
            name = "About Us"
            var intent = Intent(this, ContentPagesActivity::class.java)
            intent.putExtra("tag", tag)
            intent.putExtra("name", name)
            startActivity(intent)
        })
    }

    private fun handlePrivacy() {
        binding.privacyTxt.setOnClickListener(View.OnClickListener {
            tag = "privacy"
            name = "Privacy Policy"
            var intent = Intent(this, ContentPagesActivity::class.java)
            intent.putExtra("tag", tag)
            intent.putExtra("name", name)
            startActivity(intent)
        })
    }

    private fun handleTerms() {
        binding.termsTxt.setOnClickListener(View.OnClickListener {
            tag = "terms"
            name = "Terms & Conditions"
            var intent = Intent(this, ContentPagesActivity::class.java)
            intent.putExtra("tag", tag)
            intent.putExtra("name", name)
            startActivity(intent)
        })
    }

}