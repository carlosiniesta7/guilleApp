package com.example.guilleapp.view.main.countrydetail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.guilleapp.view.main.model.Country

class CountryDetailViewModelFactory(private val country: Country?) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CountryDetailViewModel(country = country) as T
    }
}