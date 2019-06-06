package com.example.guilleapp.main.countrydetail

import com.example.guilleapp.main.Country

class PresenterCountryDetailImpl: PresenterCountryDetail {
    override fun getPIBPerHab(country: Country) {
        //country.PIBPerHab= (country.PIB/country.poblation).toFloat()
        country.PIBPerHab= (country.PIB*1000000000000).toFloat() / country.poblation.toFloat()
    }
}