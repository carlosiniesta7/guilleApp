package com.example.guilleapp.domain

import com.example.guilleapp.data.CountryRepository
import com.example.guilleapp.domain.model.CountryDomain
import com.example.guilleapp.domain.model.toData
import com.example.guilleapp.domain.model.toDomain

class DeleteCountryUseCase(private val countryRepository: CountryRepository, private val country: CountryDomain) {

    operator fun invoke(success: (List<CountryDomain>) -> Unit) {

        val lCountries = ArrayList<CountryDomain>()

        countryRepository.deleteCountry(country.toData()).forEach { countryData ->
            lCountries.add(countryData.toDomain())
        }

        success(lCountries)

    }
}