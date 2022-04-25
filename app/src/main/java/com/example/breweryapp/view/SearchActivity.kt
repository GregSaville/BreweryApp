package com.example.breweryapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Spinner
import com.example.breweryapp.R
import com.example.breweryapp.dto.Brewery

class SearchActivity : AppCompatActivity(), SearchView {
//set on selected item listener
    //edit text  && submit button

    val presenter = SearchPresenter(this)
    var currentSelection : String = ""
    lateinit var rvBreweries: RecyclerView
    lateinit var spnrSearch: Spinner
    lateinit var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        bindViews()

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
        initSpinner()
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
                        Log.i("asdf", "success")
                        currentSelection = "Name"
                    }
                    if (selectedItem == "City"){
                        currentSelection = "City"
                    }
                    if (selectedItem == "Distance"){
                        currentSelection = "Distance"
                    }
                    if (selectedItem == "Default"){
                        currentSelection = "Default"
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }


            }
        }


    }






