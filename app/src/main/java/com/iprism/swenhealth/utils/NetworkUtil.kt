package com.iprism.swenhealth.utils

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.annotation.RequiresPermission
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.InetSocketAddress
import java.net.Socket

object NetworkUtil {

     @SuppressLint("MissingPermission")
     fun isNetworkAvailable(context: Context): Boolean {
         val connectivityManager =
             context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
         val network = connectivityManager.activeNetwork ?: return false
         val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
         return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
     }

     suspend fun hasInternetAccess(): Boolean = withContext(Dispatchers.IO) {
         try {
             val socket = Socket()
             socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
             socket.close()
             true
         } catch (e: Exception) {
             false
         }
     }

}