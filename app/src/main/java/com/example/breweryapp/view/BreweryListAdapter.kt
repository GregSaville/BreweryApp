package com.example.breweryapp.view

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breweryapp.R
import com.example.breweryapp.dto.Brewery


class BreweryListAdapter(private val breweries: List<Brewery>) : RecyclerView.Adapter<BreweryListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_brewery, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = breweries[position].name
        holder.tvCity.text = breweries[position].city
        holder.tvType.text = breweries[position].brewery_type

    }

    override fun getItemCount(): Int {
        return breweries.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName : TextView = view.findViewById(R.id.tv_name)
        val tvCity : TextView = view.findViewById(R.id.tv_city)
        val tvType : TextView = view.findViewById(R.id.tv_type)

    }

}
