package com.example.breweryapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.breweryapp.R
import com.example.breweryapp.dto.Brewery

class SearchActivity : AppCompatActivity(), SearchView {

    val presenter = SearchPresenter(this)

    lateinit var rvBreweries: RecyclerView

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
    }

}