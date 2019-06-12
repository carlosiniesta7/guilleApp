package com.example.guilleapp.view.main.countrylist


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class CountryListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CountryListViewModel() as T
    }
}