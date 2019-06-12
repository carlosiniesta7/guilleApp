package com.example.guilleapp.domain.model

data class CountryDomain(
    var name: String,
    var poblation: Int,
    var PIB: Int,
    var PIBPerHab: Float = -1F
)