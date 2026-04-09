package com.iprism.swenhealth.activities

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iprism.swenhealth.R
import com.iprism.swenhealth.databinding.ActivityContactUsBinding
import com.iprism.swenhealth.databinding.ActivityShareAppBinding
import java.io.File
import java.io.FileOutputStream

class ShareAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShareAppBinding
    private val appLink = "https://play.google.com/store/apps/details?id=com.iprism.medrayder"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityShareAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val text = "Invite your friends to join “Swen Health App” via link below"

        val spannable = SpannableString(text)
        val start = text.indexOf("“Swen Health App”")
        val end = start + "“Swen Health App”".length

        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#B12121")),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.termsTxt.text = spannable
        handleBack()
        handleShare()
        handleCopy()
    }

    private fun handleBack() {
        binding.backIv.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun handleCopy() {
        binding.linkTxt.setOnClickListener(View.OnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("App Link", appLink)
            clipboard.setPrimaryClip(clip)
        })
    }

    private fun handleShare() {
        binding.shareLo.setOnClickListener(View.OnClickListener {
            val shareText = "Check out Swen Health App.\n\nDownload here:\n$appLink"
            try {

                val bitmap = BitmapFactory.decodeResource(resources, R.drawable.app_logo)
                val file = File(cacheDir, "share_logo.png")
                val fos = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
                fos.flush()
                fos.close()

                val uri: Uri = FileProvider.getUriForFile(
                    this,
                    "${applicationContext.packageName}.provider",
                    file
                )

                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "image/*"
                    putExtra(Intent.EXTRA_STREAM, uri)
                    putExtra(Intent.EXTRA_TEXT, shareText)
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
                startActivity(Intent.createChooser(shareIntent, "Share via"))
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Error sharing", Toast.LENGTH_SHORT).show()
            }
        })
    }

}