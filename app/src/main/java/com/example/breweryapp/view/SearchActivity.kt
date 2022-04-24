package com.example.breweryapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    lateinit var rvBreweries: RecyclerView
    lateinit var spnrSearch: Spinner
    lateinit var choice: String
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

            spnrSearch.onItemSelectedListener

        }


    }

}



