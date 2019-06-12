package com.example.guilleapp.view.main.countrylist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.guilleapp.data.CountryRepository
import com.example.guilleapp.data.FakeCountryDataSource
import com.example.guilleapp.domain.GetCountryUseCase
import com.example.guilleapp.view.main.model.Country
import com.example.guilleapp.view.main.model.toView

class CountryListViewModel : ViewModel() {

    private var countriesLD: MutableLiveData<List<Country>> = MutableLiveData()

    init {
        val getCountryUC =
            GetCountryUseCase(countryRepository = CountryRepository(dataSource = FakeCountryDataSource()))

        getCountryUC { lCountriesData ->
            val lCountries = ArrayList<Country>()

            lCountriesData.forEach { countryData ->
                lCountries.add(countryData.toView())
            }

            countriesLD.value = lCountries
        }
    }

    fun getCountriesLD(): LiveData<List<Country>> = countriesLD
}
