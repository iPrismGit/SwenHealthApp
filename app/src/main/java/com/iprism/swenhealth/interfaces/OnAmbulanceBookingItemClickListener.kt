package com.iprism.swenhealth.interfaces

interface OnAmbulanceBookingItemClickListener {

    fun onItemClicked(details : String)
    fun onCallClicked(mobile : String)
    fun onTrackClicked(details : String)

}