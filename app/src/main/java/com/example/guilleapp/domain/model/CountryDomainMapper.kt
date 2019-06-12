package com.example.guilleapp.domain.model

import com.example.guilleapp.data.CountryData

fun CountryData.toDomain() : CountryDomain {
    return CountryDomain(
        name = this.name,
        poblation = this.poblation,
        PIB = this.PIB,
        PIBPerHab = this.PIBPerHab
    )
}

fun CountryDomain.toData() : CountryData {
    return CountryData(
        name = this.name,
        poblation = this.poblation,
        PIB = this.PIB,
        PIBPerHab = this.PIBPerHab
    )
}