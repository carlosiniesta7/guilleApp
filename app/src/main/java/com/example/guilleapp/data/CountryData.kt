package com.example.guilleapp.data

data class CountryData(
    var name: String,
    var poblation: Int,
    var PIB: Int,
    var PIBPerHab: Float = -1F
)