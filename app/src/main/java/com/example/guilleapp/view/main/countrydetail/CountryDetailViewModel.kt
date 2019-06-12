package com.example.guilleapp.view.main.countrydetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.guilleapp.view.main.model.Country

class CountryDetailViewModel(country: Country?) : ViewModel() {

    private val countryLD: MutableLiveData<Country> = MutableLiveData()

    init {
        if (country != null) {
            getPIBPerHab(country = country)
        }
    }

    private fun getPIBPerHab(country: Country) {
        country.PIBPerHab = (country.PIB).toFloat() * 100000 / country.poblation.toFloat()

        countryLD.value = country
    }

    fun getCountryLD(): LiveData<Country> = countryLD
}