package com.example.breweryapp.service


import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.breweryapp.dto.Brewery
import com.example.breweryapp.network.RetrofitApiFactory
import com.example.breweryapp.view.BreweryApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BreweryService {

    val api = RetrofitApiFactory().getBreweryApi()
    var key = "FavList"
    var sKey = "sFavList"


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
    ) {
        api.getBreweryByCity(cityName).enqueue(object : Callback<List<Brewery>> {
            override fun onResponse(call: Call<List<Brewery>>, response: Response<List<Brewery>>) {
                if (response.isSuccessful) {
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


        })}
        fun getByDist(
            latLong : String,
            success: (List<Brewery>) -> Unit,
            failure: (errorMessage: String) -> Unit
        ) {
            api.getBreweryByDistance(latLong).enqueue(object : Callback<List<Brewery>> {
                override fun onResponse(
                    call: Call<List<Brewery>>,
                    response: Response<List<Brewery>>
                ) {
                    if (response.isSuccessful) {
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

    fun getByName(
        name : String,
        success: (List<Brewery>) -> Unit,
        failure: (errorMessage: String) -> Unit
    ) {
        api.getBreweryByName(name).enqueue(object : Callback<List<Brewery>> {
            override fun onResponse(call: Call<List<Brewery>>, response: Response<List<Brewery>>) {
                if (response.isSuccessful) {
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


        })}

    fun getByNameQueue(
        name : String,
        success: (List<Brewery>) -> Unit,
        failure: (errorMessage: String) -> Unit
    ) {
        api.getBreweryByName(name).enqueue(object : Callback<List<Brewery>> {
            override fun onResponse(call: Call<List<Brewery>>, response: Response<List<Brewery>>) {
                if (response.isSuccessful) {
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


        })}

    fun getByState(
        stateName : String,
        success: (List<Brewery>) -> Unit,
        failure: (errorMessage: String) -> Unit
    ) {
        api.getBreweryByState(stateName).enqueue(object : Callback<List<Brewery>> {
            override fun onResponse(call: Call<List<Brewery>>, response: Response<List<Brewery>>) {
                if (response.isSuccessful) {
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


        })}

    fun saveBrewery(brewery: Brewery){
        val savedBreweries = getFavBreweries()
        savedBreweries?.add(brewery.name.toString())
        updatePrefs(savedBreweries)
    }

    fun unsaveBrewery(brewery: Brewery){
        val currentBreweries = getFavBreweries()
        currentBreweries?.remove(brewery.name.toString())
        updatePrefs(currentBreweries)
    }

    private fun updatePrefs(brewList : MutableSet<String>?){
        val favList: SharedPreferences = BreweryApplication.appContext.getSharedPreferences(key, Context.MODE_PRIVATE)
        val favEditor = favList.edit()
        favEditor.putStringSet(sKey, brewList).commit()
    }

    fun getFavBreweries(): MutableSet<String>? {
        val favList: SharedPreferences = BreweryApplication.appContext.getSharedPreferences(key, Context.MODE_PRIVATE)
        return favList.getStringSet(sKey,null)
    }

}



