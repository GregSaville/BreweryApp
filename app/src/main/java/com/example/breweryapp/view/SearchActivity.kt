package com.example.breweryapp.view

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.breweryapp.R
import com.example.breweryapp.dto.Brewery
import com.example.breweryapp.service.BreweryService


class SearchActivity : AppCompatActivity(), SearchView {

    private val REQUEST_LOCATION = 1
    val brewService = BreweryService()
    val presenter = SearchPresenter(this,brewService)
    var latLong: String = ""
    var currentSelection : String = ""
    lateinit var rvBreweries: RecyclerView
    lateinit var spnrSearch: Spinner
    lateinit var searchButton: Button
    lateinit var searchText: EditText
    lateinit var homeButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        bindViews()
        initSpinner()
        searchButton.setOnClickListener(){
            presenter.makeSearch(currentSelection, searchText.text.toString())
        }

        homeButton.setOnClickListener(){
            finish()
        }

        presenter.startSearch()

    }

    override fun bindBreweries(breweries: List<Brewery>) {
        rvBreweries.layoutManager = LinearLayoutManager(this)
        rvBreweries.adapter = BreweryListAdapter(breweries)
    }

    override fun ArrayAdapter() {
        TODO("Not yet implemented")
    }


    private fun bindViews(){
        rvBreweries = findViewById(R.id.rv_breweries)
        spnrSearch = findViewById(R.id.spnr_search)
        searchText = findViewById(R.id.spinner_edit_text)
        searchButton = findViewById(R.id.btn_search)
        homeButton = findViewById(R.id.bt_SearchHome)
    }

    private fun initSpinner(){
        ArrayAdapter.createFromResource(
            this,
            R.array.brewery_spinner_array,
            android.R.layout.simple_spinner_item).also {
                adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnrSearch.adapter = adapter
            spnrSearch.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{


                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedItem = parent?.getItemAtPosition(position).toString()
                    if (selectedItem == "Name"){
                        //Log.i("asdf", "success")
                        currentSelection = "Name"
                    }
                    if (selectedItem == "City"){
                        currentSelection = "City"
                    }
                    if (selectedItem == "Distance"){
                        currentSelection = "Distance"
                        getLocation()
                        searchText.setText(latLong)
                    }
                    if (selectedItem == "Default"){
                        currentSelection = "Default"
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    currentSelection = "Default"
                }
            }


            }
        }

    private fun getLocation() {
        val nManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION
            )
        } else {
            val locationGPS: Location? =
                nManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (locationGPS != null) {
                val lat: Double = locationGPS.latitude
                val long: Double = locationGPS.longitude
                latLong= "$lat,$long"
            } else {
                Toast.makeText(this, "Unable to find location.", Toast.LENGTH_LONG).show()
            }
        }
    }


    }






