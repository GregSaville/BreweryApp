package com.example.breweryapp.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.breweryapp.R
import com.example.breweryapp.dto.Brewery
import com.example.breweryapp.service.BreweryService
import com.example.breweryapp.view.DetailActivity as DetailActivity


class BreweryListAdapter(private val breweries: List<Brewery>) : RecyclerView.Adapter<BreweryListAdapter.ViewHolder>() {

    private val brewService = BreweryService()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_brewery, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = breweries[position].name
        holder.tvCity.text = breweries[position].city
        holder.tvType.text = breweries[position].brewery_type
        holder.btDetail.setOnClickListener(){
            val DetailActivityIntent = Intent(holder.btDetail.context,DetailActivity::class.java)
            DetailActivityIntent.putExtra("Name",breweries[position].name.toString())
            startActivity(holder.btDetail.context, DetailActivityIntent,Bundle())
        }
        holder.btFavorites.setOnClickListener(){
            if(holder.btFavorites.isChecked){
                brewService.saveBrewery(breweries[position])
                Log.i("asdf",brewService.getFavBreweries().toString())
            }
            else{
                brewService.unsaveBrewery(breweries[position])
                Log.i("asdf",brewService.getFavBreweries().toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return breweries.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName : TextView = view.findViewById(R.id.tv_name)
        val tvCity : TextView = view.findViewById(R.id.tv_city)
        val tvType : TextView = view.findViewById(R.id.tv_type)
        val btDetail : Button = view.findViewById(R.id.bt_details)
        val btFavorites : ToggleButton = view.findViewById(R.id.bt_favorites)
    }

}
