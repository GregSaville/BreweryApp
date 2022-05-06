package com.example.breweryapp.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import com.example.breweryapp.dto.Brewery
import com.example.breweryapp.service.BreweryService

class DetailPresenter(val view: DetailActivity, val brewService: BreweryService) {

    var currentBrew : Brewery? = null

    fun start(brewName: String){
        getByName(brewName)
    }

    private fun getByName(name: String) {
        brewService.getByName(name,
            success = {
                view.loadInfo(it[0])
                currentBrew = it[0]
            },
            failure = {
                Log.e("asdf", "Error in getByCity")
            }
        )
    }

    fun startMap(context: DetailActivity, intent: Intent) {
        val lat = currentBrew?.latitude
        val longi = currentBrew?.longitude
        intent.putExtra("latLong", "$lat,$longi")
        startActivity(context, intent, Bundle())
    }
}