package com.example.breweryapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.breweryapp.R
import com.example.breweryapp.databinding.ActivityMapsBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val strLatLong = intent.getStringExtra("latLong")
        val strArray = strLatLong!!.split(",")
        val lat = strArray.get(0).toDouble()
        val long = strArray.get(1).toDouble()
        val sydney = LatLng(lat , long)
        val zoomLevel :Float = 16F

        mMap.addMarker(MarkerOptions().position(sydney).title("Marker at Brewery"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,zoomLevel))
    }
}