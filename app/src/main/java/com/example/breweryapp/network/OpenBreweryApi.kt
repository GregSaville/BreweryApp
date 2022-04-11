package com.example.breweryapp.network

import com.example.breweryapp.dto.Brewery
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenBreweryApi {

    @GET("breweries")
    fun getExampleBrewery(): Call<List<Brewery>>

    @GET("breweries")
    fun getBreweryByCity(@Query(value = "by_city") by_city: String) : Call<List<Brewery>>

    @GET("breweries")
    fun getBreweryByDistance(@Query(value = "by_dist") by_dist: Double, longitude: Double) : Call<List<Brewery>>
}