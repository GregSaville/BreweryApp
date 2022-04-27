package com.example.breweryapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.breweryapp.R
import com.example.breweryapp.dto.Brewery
import com.example.breweryapp.service.BreweryService

class SearchActivity : AppCompatActivity(), SearchView {
//set on selected item listener
    //edit text  && submit button
    val brewService = BreweryService()
    val presenter = SearchPresenter(this,brewService)
    var currentSelection : String = ""
    lateinit var rvBreweries: RecyclerView
    lateinit var spnrSearch: Spinner
    lateinit var searchButton: Button
    lateinit var searchText: EditText

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
        searchText = findViewById(R.id.spinner_edit_text)
        searchButton = findViewById(R.id.btn_search)
        searchButton.setOnClickListener(){
            presenter.makeSearch(currentSelection, searchText.text.toString())
        }
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






