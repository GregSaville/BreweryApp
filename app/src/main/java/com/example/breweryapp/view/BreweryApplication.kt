package com.example.breweryapp.view

import android.app.Application
import android.content.Context

class BreweryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        BreweryApplication.appContext = applicationContext
    }
    companion object {
        lateinit var appContext: Context
    }
}