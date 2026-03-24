package com.iprism.swenhealth.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.HomePagerAdapter
import com.iprism.swenhealth.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var backPressedOnce = false
    private var fragment = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragment = intent.getStringExtra("fragment").toString()
        setupViewPager()
        setupFragmentLoading()
    }

    private fun setupFragmentLoading() {
        if (fragment.isEmpty()) {
            binding.bottomNavigationView.selectedItemId = R.id.home_nav
            binding.viewPager.setCurrentItem(0, false)
        } else if (fragment.equals("Hospitals", true)) {
            binding.bottomNavigationView.selectedItemId = R.id.hospitals_nav
            binding.viewPager.setCurrentItem(1, false)
        }
    }

    private fun setupViewPager() {
        val adapter = HomePagerAdapter(this)
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.adapter = adapter
        handleBottomNav()
    }

    private fun handleBottomNav() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_nav -> binding.viewPager.setCurrentItem(0, false)
                R.id.hospitals_nav -> binding.viewPager.setCurrentItem(1, false)
                R.id.medicines_nav -> binding.viewPager.setCurrentItem(2, false)
                R.id.lab_tests_nav -> binding.viewPager.setCurrentItem(3, false)
                R.id.diagnostic_nav -> binding.viewPager.setCurrentItem(4, false)
            }
            true
        }

    }

    @SuppressLint("UseKtx")
    fun changeFragment(position: Int) {
        binding.viewPager.setCurrentItem(position, false)
        binding.bottomNavigationView.menu.getItem(position).isChecked = true
    }

    @Deprecated("This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    @SuppressLint("MissingSuperCall", "GestureBackNavigation")
    override fun onBackPressed() {
        val currentItem = binding.viewPager.currentItem

        if (currentItem != 0) {
            changeFragment(0)
        } else {
            if (backPressedOnce) {
                finishAffinity()
                return
            }

            backPressedOnce = true

            val snackbar = Snackbar.make(
                findViewById(android.R.id.content),
                "Are you sure you want to exit?",
                Snackbar.LENGTH_LONG
            )
                .setAction("Yes") {
                    finishAffinity()
                }

            snackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.app_primary_color))
            snackbar.setTextColor(ContextCompat.getColor(this, R.color.white))
            snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.white))
            snackbar.show()

            Handler(Looper.getMainLooper()).postDelayed({
                backPressedOnce = false
            }, 2000)
        }
    }

}