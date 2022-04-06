package com.example.breweryapp.dto

//import com.google.gson.annotations.SerializedName


data class Brewery(
    //yomesayin
    val id: Int?,
    val name: String?,
   // @SerializedName("brewery_type")
    val brewery_type: String?,
    val street: String?,
    val address_2: String?,
    val address_3: String?,
    val city: String?,
    val state: String?,
    val county_province: String?,
    val postal_code: String?,
    val country: String?,
    val longitude: String?,
    val latitude: String?,
    val phone: String?,
    val website_url: String?,
    val updated_at: String?,
    val created_at: String?
){}
