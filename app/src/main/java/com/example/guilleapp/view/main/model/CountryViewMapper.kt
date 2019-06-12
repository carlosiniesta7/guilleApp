package com.example.guilleapp.view.main.model

import com.example.guilleapp.R
import com.example.guilleapp.domain.model.CountryDomain

fun CountryDomain.toView() : Country {
    return Country(
        name = this.name,
        poblation = this.poblation,
        PIB = this.PIB,
        PIBPerHab = this.PIBPerHab,
        flag = getFlag(name = this.name)
    )
}

fun getFlag(name: String): Int {
    return when (name) {
        "Italia" -> R.drawable.italy
        "Francia" -> R.drawable.francia
        "Alemania" -> R.drawable.alemania
        "España" -> R.drawable.espana
        "El Escorial" -> R.drawable.escorial
        else -> {
            R.drawable.ic_launcher_flag
        }
    }
}

fun Country.toDomain() : CountryDomain {
    return CountryDomain(
        name = this.name,
        poblation = this.poblation,
        PIB = this.PIB,
        PIBPerHab = this.PIBPerHab
    )
}
