package com.example.guilleapp.domain

import com.example.guilleapp.data.CountryRepository
import com.example.guilleapp.domain.model.CountryDomain
import com.example.guilleapp.domain.model.toData
import com.example.guilleapp.domain.model.toDomain

class GetPIBPerHabUseCase(private val countryRepository: CountryRepository, private val country: CountryDomain) {
    operator fun invoke(success: (CountryDomain) -> Unit) {
        val country = countryRepository.getPIBPerHab(country.toData())
        success(country.toDomain())
    }
}