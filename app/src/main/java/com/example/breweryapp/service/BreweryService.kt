package com.example.breweryapp.service

import com.example.breweryapp.dto.Brewery
import com.example.breweryapp.network.RetrofitApiFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BreweryService {

    val api = RetrofitApiFactory().getBreweryApi()

    fun getExampleBrewey(
        success: (List<Brewery>) -> Unit,
        failure: (errorMessage: String) -> Unit
    ){
        api.getExampleBrewery().enqueue(object: Callback<List<Brewery>> {
            override fun onResponse(call: Call<List<Brewery>>, response: Response<List<Brewery>>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        success(it)
                    } ?: run {
                        failure("no Brewery got in onResponse")
                    }
                } else {
                    failure("error with onResponse")
                }
            }

            override fun onFailure(call: Call<List<Brewery>>, t: Throwable) {
                failure("Error, OnFailure")
            }


        })
    }

    fun getByCity(
        cityName : String,
        success: (List<Brewery>) -> Unit,
        failure: (errorMessage: String) -> Unit
    ){
        api.getBreweryByCity(cityName).enqueue(object: Callback<List<Brewery>> {
            override fun onResponse(call: Call<List<Brewery>>, response: Response<List<Brewery>>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        success(it)
                    } ?: run {
                        failure("no Brewery got in onResponse")
                    }
                } else {
                    failure("error with onResponse")
                }
            }

            override fun onFailure(call: Call<List<Brewery>>, t: Throwable) {
                failure("Error, OnFailure")
            }


        })
    }


}
