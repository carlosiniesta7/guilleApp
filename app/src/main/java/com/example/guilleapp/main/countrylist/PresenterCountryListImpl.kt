package com.example.guilleapp.main.countrylist

import com.example.guilleapp.R
import com.example.guilleapp.main.Country

class PresenterCountryListImpl(private val view: CountryListFragmentView) : PresenterCountryList {
    override fun getCountries()  {
        view.showCountries(countries = addCountries())
    }

    private fun addCountries() : ArrayList<Country> =
        ArrayList<Country>().also { countries ->
            countries.add(
                Country(
                    "Italia",
                    60600000,
                    R.drawable.italy,
                    1395
                )
            )
            countries.add(
                Country(
                    "Francia",
                    67000000,
                    R.drawable.francia,
                    2583
                )
            )
            countries.add(
                Country(
                    "Alemania",
                    82800000,
                    R.drawable.alemania,
                    3677
                )
            )
            countries.add(
                Country(
                    "España",
                    46700000,
                    R.drawable.espana,
                    1311
                )
            )
            countries.add(
                Country(
                    "El Escorial",
                    15842,
                    R.drawable.escorial,
                    9999
                )
            )
        }
}