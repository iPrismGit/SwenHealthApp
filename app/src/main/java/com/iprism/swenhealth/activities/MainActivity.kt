package com.iprism.swenhealth.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.HomePagerAdapter
import com.iprism.swenhealth.databinding.ActivityMainBinding
import com.iprism.swenhealth.databinding.LogOutDialogBinding
import com.iprism.swenhealth.databinding.MenuBottomSheetBinding

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

    fun showMenuBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(this, R.style.FullScreenBottomSheetDialog)

        val bottomSheetBinding = MenuBottomSheetBinding.inflate(layoutInflater)
        bottomSheetDialog.setContentView(bottomSheetBinding.root)

        bottomSheetBinding.crossIv.setOnClickListener {
            bottomSheetDialog.dismiss()
        }

        val bottomSheet = bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheet?.setBackgroundColor(Color.TRANSPARENT)

        bottomSheet?.let {
            val behavior = BottomSheetBehavior.from(it)
            it.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        bottomSheetDialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            setFlags(
                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS,
                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
            )
            decorView.setPadding(0, getStatusBarHeight(), 0, 0)
        }

        bottomSheetBinding.offersLl.setOnClickListener { p0 ->
            startActivity(Intent(this, OfferHospitalsActivity::class.java))
        }

        bottomSheetBinding.medlockerLl.setOnClickListener { p0 ->
            startActivity(Intent(this, MedLockerActivity::class.java))
        }

        bottomSheetBinding.contactUsLl.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ContactUsActivity::class.java))
        })

        bottomSheetBinding.shareappLl.setOnClickListener { p0 ->
            startActivity(Intent(this, ShareAppActivity::class.java))
        }

        bottomSheetBinding!!.aboutUsLl.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, AboutUsActivity::class.java))
        })

        bottomSheetBinding!!.upArrowImg.setOnClickListener(View.OnClickListener {
            bottomSheetBinding!!.hospitalBookingsDetailsLl.visibility = View.GONE
            bottomSheetBinding!!.upArrowImg.visibility = View.GONE
            bottomSheetBinding!!.downArrowImg.visibility = View.VISIBLE
        })

        bottomSheetBinding!!.downArrowImg.setOnClickListener(View.OnClickListener {
            bottomSheetBinding!!.hospitalBookingsDetailsLl.visibility = View.VISIBLE
            bottomSheetBinding!!.upArrowImg.visibility = View.VISIBLE
            bottomSheetBinding!!.downArrowImg.visibility = View.GONE
        })

        bottomSheetBinding!!.logoutLl.setOnClickListener(View.OnClickListener {
            showLogOutDialog()
        })

        bottomSheetDialog.show()
    }

    fun showLogOutDialog() {
        val dialog = Dialog(this)
        val logoutBinding = LogOutDialogBinding.inflate(layoutInflater)
        dialog.setContentView(logoutBinding.root)
        dialog.window?.setBackgroundDrawableResource(R.drawable.edit_text_bg)
        logoutBinding.yesBtn.setOnClickListener(View.OnClickListener {
         //   user?.logoutUser()
            startActivity(Intent(this, LoginActivity::class.java))
            dialog.dismiss()

        })

        logoutBinding.noBtn.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
        })

        dialog.show()
    }

    fun getStatusBarHeight(): Int {
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (resourceId > 0) resources.getDimensionPixelSize(resourceId) else 0
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