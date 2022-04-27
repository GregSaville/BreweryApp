package com.example.breweryapp.view

import android.util.Log
import com.example.breweryapp.service.BreweryService

// presenter should only have 1 view


class SearchPresenter(val view: SearchActivity,val brewService : BreweryService) {



    fun startSearch() {
        getExampleList()
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
    private fun getByDist(latLong : String) {
        brewService.getByDist(latLong,
            success = {
                view.bindBreweries(it)
            },
            failure = {
                Log.e("asdf", "Error in getByDist")
            }
        )
    }
    private fun getByName(name: String) {
        brewService.getByName(name,
            success = {
                view.bindBreweries(it)
            },
            failure = {
                Log.e("asdf", "Error in getByCity")
            }
        )
    }
    private fun getByState(state: String) {
        brewService.getByState(state,
            success = {
                view.bindBreweries(it)
            },
            failure = {
                Log.e("asdf", "Error in getByCity")
            }
        )
    }

    fun makeSearch(currentSelection: String, value: String) {
        if(currentSelection == "Name"){
            getByName(value)
        }
        if(currentSelection == "City"){
            getByCity(value)
        }
        if(currentSelection == "Distance"){
            getByDist(value)
        }
        if(currentSelection == "Default"){
            getExampleList()
        }
    }
}