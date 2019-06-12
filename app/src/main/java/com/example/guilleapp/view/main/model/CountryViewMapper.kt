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
    return R.drawable.italy
}
