package com.example.breweryapp.view

import android.widget.Button
import android.widget.SearchView
import com.example.breweryapp.service.BreweryService
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import org.junit.Test

class MainPresenterTest {

    val searchButton: Button = mockk(relaxed = true)
    val view: SearchView = mockk(relaxed = true)
    val brewService: BreweryService = mockk(relaxed = true)
    val presenter = SearchPresenter(view)

    @Test
    fun `On start, display search button`(){
        assertEquals(3, 2+1)
    }
    @Test
    fun `On start, call getBreweries`(){
        presenter.startSearch()
        verify { brewService.getExampleBrewey(any(), any()) }
    }

}