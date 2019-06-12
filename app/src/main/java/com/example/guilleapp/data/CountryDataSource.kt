package com.example.guilleapp.data

interface CountryDataSource {
    fun getCountries() : List<CountryData>
}