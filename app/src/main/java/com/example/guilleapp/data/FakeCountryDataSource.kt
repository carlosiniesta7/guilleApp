package com.example.guilleapp.data

class FakeCountryDataSource : CountryDataSource {
    override fun getCountries() : List<CountryData> = ArrayList<CountryData>().also { countries ->
        countries.add(
            CountryData(
                "Italia",
                60600000,
                1395
            )
        )
        countries.add(
            CountryData(
                "Francia",
                67000000,
                2583
            )
        )
        countries.add(
            CountryData(
                "Alemania",
                82800000,
                3677
            )
        )
        countries.add(
            CountryData(
                "España",
                46700000,
                1311
            )
        )
        countries.add(
            CountryData(
                "El Escorial",
                15842,
                9999
            )
        )
    }
}