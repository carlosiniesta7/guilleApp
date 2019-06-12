package com.example.guilleapp.main.countrydetail

import android.os.Parcel
import android.os.Parcelable
import com.example.guilleapp.main.Country

data class CountryDetailViewModelIn(val country: Country?) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readParcelable<Country>(Country::class.java.classLoader))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(country, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CountryDetailViewModelIn> {
        override fun createFromParcel(parcel: Parcel): CountryDetailViewModelIn {
            return CountryDetailViewModelIn(parcel)
        }

        override fun newArray(size: Int): Array<CountryDetailViewModelIn?> {
            return arrayOfNulls(size)
        }
    }
}