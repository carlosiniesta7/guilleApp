package com.example.guilleapp.domain

import com.example.guilleapp.data.CountryRepository
import com.example.guilleapp.domain.model.CountryDomain
import com.example.guilleapp.domain.model.toDomain

class GetCountryUseCase(private val countryRepository: CountryRepository) {
    operator fun invoke(success: (List<CountryDomain>) -> Unit) {
        val lCountries = ArrayList<CountryDomain>()

        countryRepository.getCountries().forEach { countryData ->
            lCountries.add(countryData.toDomain())
        }

        success(lCountries)
    }
}