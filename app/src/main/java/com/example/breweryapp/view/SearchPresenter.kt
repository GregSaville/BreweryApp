package com.example.breweryapp.view

import android.util.Log
import com.example.breweryapp.service.BreweryService

class SearchPresenter(val view: SearchActivity) {
    val brewService = BreweryService()

    fun startSearch() {
        //getByCity("fargo")
        getByDist(38.3977, 77.0365)
    }


    private fun getExampleList() {
        brewService.getExampleBrewey(
            success = { breweries ->
                view.bindBreweries(breweries)
            },
            failure = {
                Log.e("asdf", "Error in getExampleList()")
            }
        )
    }

    private fun getByCity(city: String) {
        brewService.getByCity(city,
            success = {
                view.bindBreweries(it)
            },
            failure = {
                Log.e("asdf", "Error in getByCity")
            }
        )
    }
    private fun getByDist(latitude: Double, longitude: Double) {
        brewService.getByDist(latitude,longitude,
            success = {
                view.bindBreweries(it)
            },
            failure = {
                Log.e("asdf", "Error in getByDist")
            }
        )
    }
}