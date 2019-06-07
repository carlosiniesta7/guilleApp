package com.example.guilleapp.main.countrydetail

import com.example.guilleapp.main.Country

class PresenterCountryDetailImpl(private val view: CountryDetailFragmentView): PresenterCountryDetail {
    override fun getPIBPerHab(country: Country) {
        country.PIBPerHab= (country.PIB).toFloat()*100000 / country.poblation.toFloat()

        view.showCountry(country = country)
    }
}