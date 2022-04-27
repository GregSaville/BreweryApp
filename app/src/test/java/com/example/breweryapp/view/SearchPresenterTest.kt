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
    fun `On search click, search by city`(){
        presenter.makeSearch("City", "Fargo")

        verify { brewService.getByCity(any(),any(),any()) }
    }

    @Test
    fun `On search click, search by default`(){
        presenter.makeSearch("Default", "")

        verify{ brewService.getExampleBrewey(any(),any()) }
    }


}