package com.example.guilleapp.main.countrydetail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.guilleapp.main.Country

class CountryDetailViewModelFactory(private val country: Country?) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CountryDetailViewModel(country = country) as T
    }
}