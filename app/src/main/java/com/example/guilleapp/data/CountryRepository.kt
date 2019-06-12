package com.example.guilleapp.data


class CountryRepository(private val dataSource: CountryDataSource) {
    fun getCountries() : List<CountryData> = dataSource.getCountries()
}