package com.example.guilleapp.main

import java.io.Serializable

data class Country(
    var name: String,
    var poblation: Int,
    var flag: Int,
    var PIB: Int,
    var PIBPerHab: Float = -1F
) : Serializable