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
    fun getBreweryByDistance(@Query(value = "by_dist") by_dist : String) : Call<List<Brewery>>
    @GET("breweries")
    fun getBreweryByName(@Query(value = "by_name") by_name: String) : Call<List<Brewery>>
    @GET("breweries")
    fun getBreweryByState(@Query(value = "by_state") by_state: String) : Call<List<Brewery>>
}