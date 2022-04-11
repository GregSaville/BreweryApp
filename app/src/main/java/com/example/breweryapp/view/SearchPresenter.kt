package com.example.breweryapp.view

import android.util.Log
import com.example.breweryapp.service.BreweryService

class SearchPresenter(val view: SearchActivity) {
    val brewService = BreweryService()

    fun startSearch() {
        getByCity("fargo")
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
}