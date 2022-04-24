package com.example.breweryapp.view

import com.example.breweryapp.dto.Brewery

interface SearchView {
    fun bindBreweries(breweries: List<Brewery>)
    fun ArrayAdapter()

}