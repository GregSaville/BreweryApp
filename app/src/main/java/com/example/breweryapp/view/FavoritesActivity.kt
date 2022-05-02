package com.example.breweryapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.breweryapp.R
import com.example.breweryapp.dto.Brewery
import com.example.breweryapp.service.BreweryService

class FavoritesActivity : AppCompatActivity() {
    lateinit var rvFavs : RecyclerView
    lateinit var btBack : Button

    val brewService = BreweryService()

    var brewNames = brewService.getFavBreweries()
    val favBreweries : MutableList<Brewery> = mutableListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        for(brewery in brewNames!!){
            brewService.getByName(brewery,
                success = {
                    favBreweries.add(it[0])
                },
                failure = {
                    Log.e("asdf","String not found")
                })
        }

        bindBreweries(favBreweries)


    }

    fun bindBreweries(breweries: List<Brewery>) {
        rvFavs.layoutManager = LinearLayoutManager(this)
        rvFavs.adapter = BreweryListAdapter(breweries)
    }
}