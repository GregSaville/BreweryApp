package com.example.breweryapp.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.breweryapp.R
import com.example.breweryapp.service.BreweryService

class MainActivity : AppCompatActivity() {
    private lateinit var searchBtn: Button
    private lateinit var favoritesBtn: Button
    val favList: SharedPreferences = getSharedPreferences("favoritesList", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val brewService = BreweryService()

        brewService.getExampleBrewey(
            success = {

        },
            failure = {
                Log.e("asdf",it)
            })


        //buttons
        searchBtn = findViewById(R.id.search_button)
        favoritesBtn = findViewById(R.id.favorites_button)



        searchBtn.setOnClickListener {
            val searchActivityIntent = Intent(this, SearchActivity::class.java)
            startActivity(searchActivityIntent)
        }

//        favoritesBtn.setOnClickListener {
//            val favoritesActivityIntent = Intent(this, FavoritesActivity::class.java)
//            startActivity(favoritesActivityIntent)
//        }
    }
}
