package com.example.guilleapp.view.main.countrydetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.guilleapp.data.CountryRepository
import com.example.guilleapp.data.FakeCountryDataSource
import com.example.guilleapp.domain.DeleteCountryUseCase
import com.example.guilleapp.domain.GetPIBPerHabUseCase
import com.example.guilleapp.view.main.model.Country
import com.example.guilleapp.view.main.model.toDomain
import com.example.guilleapp.view.main.model.toView

class CountryDetailViewModel(country: Country?) : ViewModel(), CountryDetailFragment.ButtonClick {


    private val countryLD: MutableLiveData<Country> = MutableLiveData()

    private var lCountry: Country? = null

    private var countryD: Country? = country

    init {
        if (country != null) {
            val getPIBPerHabUseCase =
                GetPIBPerHabUseCase(CountryRepository(FakeCountryDataSource()), country = country.toDomain())

            getPIBPerHabUseCase { countryData ->
                lCountry = countryData.toView()
            }

            countryLD.value = lCountry

        }
    }

    fun getCountryLD(): LiveData<Country> = countryLD

    override fun buttonPressed() {
        countryD?.toDomain()?.let { DeleteCountryUseCase(CountryRepository(FakeCountryDataSource()), it) }
    }
}