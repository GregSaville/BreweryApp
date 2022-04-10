package com.example.breweryapp.network

import com.example.breweryapp.dto.Brewery
import retrofit2.Call
import retrofit2.http.GET

interface OpenBreweryApi {

    @GET(" ")
    fun getExampleBrewery(): Call<List<Brewery>>

}