package com.example.guilleapp.data

interface CountryDataSource {
    fun getCountries() : List<CountryData>
    fun deleteCountry(country: CountryData) : List<CountryData>
}