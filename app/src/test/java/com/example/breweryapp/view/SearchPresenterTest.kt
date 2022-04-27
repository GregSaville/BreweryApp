package com.example.breweryapp.view

import com.example.breweryapp.service.BreweryService
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class SearchPresenterTest {

    val view: SearchActivity = mockk(relaxed = true)
    val brewService: BreweryService = mockk(relaxed = true)
    val presenter = SearchPresenter(view, brewService)

    @Test
    fun `When searching by name, search by name`(){
        presenter.makeSearch("Name", "Drekker")

        verify { brewService.getByName("Drekker",any(),any()) }
    }

    @Test
    fun `When searching by distance, search by distance`(){
        presenter.makeSearch("Distance", "5,5")

        verify { brewService.getByDist("5,5",any(),any()) }
    }

    @Test
    fun `When searching by city, search by city`(){
        presenter.makeSearch("City", "Fargo")

        verify { brewService.getByCity("Fargo",any(),any()) }
    }

    @Test
    fun `When default selected in spinner, search by default`(){
        presenter.makeSearch("Default", "")

        verify{ brewService.getExampleBrewey(any(),any()) }
    }


}