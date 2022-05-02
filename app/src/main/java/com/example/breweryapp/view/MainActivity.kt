package com.example.breweryapp.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.breweryapp.R
import com.example.breweryapp.dto.Brewery
import com.example.breweryapp.service.BreweryService
import java.lang.Math.random
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var searchBtn: Button
    private lateinit var favoritesBtn: Button
    private lateinit var brewOfDay: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val brewService = BreweryService()


        //buttons
        searchBtn = findViewById(R.id.search_button)
        favoritesBtn = findViewById(R.id.favorites_button)
        brewOfDay = findViewById(R.id.rv_BofD)

        brewService.getExampleBrewey(
            success = {
                val brew = listOf<Brewery>(it[Random.nextInt(it.size)])

                bindBreweries(brew)
            },
            failure = {
                Log.e("asdf",it)
            })




        searchBtn.setOnClickListener {
            val searchActivityIntent = Intent(this, SearchActivity::class.java)
            startActivity(searchActivityIntent)
        }

//        favoritesBtn.setOnClickListener {
//            val favoritesActivityIntent = Intent(this, FavoritesActivity::class.java)
//            startActivity(favoritesActivityIntent)
//        }
    }

    fun bindBreweries(breweries: List<Brewery>) {
        brewOfDay.layoutManager = LinearLayoutManager(this)
        brewOfDay.adapter = BreweryListAdapter(breweries)
    }
}
