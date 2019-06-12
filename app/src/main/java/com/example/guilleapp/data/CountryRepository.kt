package com.example.guilleapp.data


class CountryRepository(private val dataSource: CountryDataSource) {
    fun getCountries(): List<CountryData> = dataSource.getCountries()

    fun getPIBPerHab(country: CountryData): CountryData {
        country.PIBPerHab = (country.PIB).toFloat() * 100000 / country.poblation.toFloat()
        return country
    }
}
