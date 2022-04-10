package com.example.breweryapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiFactory {

    fun getBreweryApi(): OpenBreweryApi {
        return Retrofit.Builder()
            .baseUrl("https://api.openbrewerydb.org/breweries/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenBreweryApi::class.java)
    }
}