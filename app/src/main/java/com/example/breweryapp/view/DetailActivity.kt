package com.example.breweryapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.breweryapp.R
import com.example.breweryapp.dto.Brewery
import com.example.breweryapp.service.BreweryService

class DetailActivity : AppCompatActivity() {
    lateinit var btHome: Button
    lateinit var btMap: Button
    lateinit var tvName: TextView
    lateinit var tvCity: TextView
    lateinit var tvPhone: TextView
    lateinit var tvSite: TextView
    lateinit var tvStreet: TextView
    val brewService = BreweryService()
    val presenter = DetailPresenter(this, brewService)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val brewName = intent.getStringExtra("Name")
        presenter.start(brewName.toString())
        bindViews()

        btHome.setOnClickListener(){
            finish()
        }

        btMap.setOnClickListener(){
//            val MapsActivityIntent = Intent(this, MapsActivity::class.java)
//            presenter.startMap(this,MapsActivityIntent)
            Toast.makeText(this, "WIP -- Come back Later!", Toast.LENGTH_LONG).show()
        }

    }



    private fun bindViews(){
        btHome = findViewById(R.id.home)
        btMap = findViewById(R.id.bt_map)
        tvName = findViewById(R.id.dtName)
        tvCity = findViewById(R.id.dtCity)
        tvPhone = findViewById(R.id.dtPhone)
        tvSite = findViewById(R.id.dtSite)
        tvStreet = findViewById(R.id.dtStreet
        )

    }

    fun loadInfo(it: Brewery) {
        tvName.text = it.name
        tvCity.text = it.city
        tvPhone.text = it.phone
        tvSite.text = it.website_url
        tvStreet.text = it.street
    }
}