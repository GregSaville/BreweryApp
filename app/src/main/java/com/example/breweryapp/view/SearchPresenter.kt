package com.example.breweryapp.view

import android.util.Log
import android.widget.SearchView
import com.example.breweryapp.service.BreweryService

class SearchPresenter(val view: SearchView) {
    val brewService = BreweryService()

    fun startSearch(){
        getExampleList()
    }

    fun getExampleList(){
        brewService.getExampleBrewey(
            success = { breweries ->
                view.bindBreweries(breweries)
            },
            failure = {
                Log.e("asdf","Error in getExampleList()")
            }
        )
    }
}