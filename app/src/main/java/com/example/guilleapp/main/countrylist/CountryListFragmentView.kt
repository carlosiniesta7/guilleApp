package com.example.guilleapp.main.countrylist

import com.example.guilleapp.main.Country

interface CountryListFragmentView {
    fun showCountries(countries: MutableList<Country>)
}