package com.iprism.swenhealth.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.iprism.swenhealth.R
import com.iprism.swenhealth.adapters.HomeCareHospitalsAdapter
import com.iprism.swenhealth.databinding.ActivityHomeCareServiceHospitalBinding
import com.iprism.swenhealth.databinding.BookHomeServiceForBottomSheetBinding
import com.iprism.swenhealth.databinding.PaymentTypeBottomSheetBinding
import com.iprism.swenhealth.interfaces.OnHomeCareServiceHospitalClickListener
import com.iprism.swenhealth.utils.ToastUtils

class HomeCareServiceHospitalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeCareServiceHospitalBinding
    private var registerFor = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeCareServiceHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleBack()
        setupAdapter()
    }

    private fun setupAdapter() {
        val adapter = HomeCareHospitalsAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.categoriesRv.adapter = adapter
        binding.categoriesRv.layoutManager = layoutManager
        adapter.setupListener(object  : OnHomeCareServiceHospitalClickListener{
            override fun onItemClick(position: String) {
                showRegisterForBottomSheet(this@HomeCareServiceHospitalActivity)
            }

        })
    }

    private fun handleBack() {
        binding.backImg.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showRegisterForBottomSheet(context: Context) {
        val bottomSheetDialog = BottomSheetDialog(context)
        val labTestSelectMembersBottomSheetBinding = BookHomeServiceForBottomSheetBinding.inflate(
            LayoutInflater.from(context))
        bottomSheetDialog.setContentView(labTestSelectMembersBottomSheetBinding.root)
        bottomSheetDialog.setOnShowListener { dialog -> val bottomSheet = (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.setBackgroundResource(R.drawable.top_edges_bg)
        }

        labTestSelectMembersBottomSheetBinding.crossImg.setOnClickListener(View.OnClickListener {
            bottomSheetDialog.cancel()
        })

        labTestSelectMembersBottomSheetBinding.registerForYouTxt.setOnClickListener { p0 ->
            setupUiStyling(labTestSelectMembersBottomSheetBinding.registerForYouTxt, labTestSelectMembersBottomSheetBinding.registerForSomeoneTxt)
            registerFor = "RegisterForYou"
        }

        labTestSelectMembersBottomSheetBinding.registerForSomeoneTxt.setOnClickListener { p0 ->
            setupUiStyling(labTestSelectMembersBottomSheetBinding.registerForSomeoneTxt, labTestSelectMembersBottomSheetBinding.registerForYouTxt)
            registerFor = "RegisterForSomeone"
        }

        labTestSelectMembersBottomSheetBinding.proceedBtn.setOnClickListener { p0 ->
            if(registerFor.isEmpty()){
                ToastUtils.showErrorCustomToast(this, "Please Select Register For..!")
            }else{
                val intent = Intent(this, HomeServicePatientDetailsActivity::class.java)
                intent.putExtra("registerFor", registerFor)
                startActivity(intent)
            }
        }
//        labTestSelectMembersBottomSheetBinding.coupontDiscountTxt.text = "₹${details!!.couponDiscount}"
//        labTestSelectMembersBottomSheetBinding.totalTxt.text = "₹${details!!.consultationFee}"
//        labTestSelectMembersBottomSheetBinding.itemTotalTxt.text = "₹${price!!.discontPrice}"
        bottomSheetDialog.show()
    }

    private fun setupUiStyling(textView: TextView, textView1: TextView){
        textView.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.selected_text_bg))
        textView1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.edit_text_bg))
    }

}