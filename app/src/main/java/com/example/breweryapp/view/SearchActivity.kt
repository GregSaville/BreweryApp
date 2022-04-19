package com.example.breweryapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Spinner
import com.example.breweryapp.R
import com.example.breweryapp.dto.Brewery

class SearchActivity : AppCompatActivity(), SearchView {

    val presenter = SearchPresenter(this)

    lateinit var rvBreweries: RecyclerView
    lateinit var spnrSearch: Spinner

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


    private fun bindViews(){
        rvBreweries = findViewById(R.id.rv_breweries)
        spnrSearch = findViewById(R.id.spnr_search)
        //initSpinner()
    }
/*
    private fun initSpinner(){
        val spnrList = listOf("Name","City","Distance","Default")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,spnrList)
        spnrSearch.adapter = adapter

    }
*/
}