package com.example.guilleapp.main

import android.os.Parcel
import android.os.Parcelable

data class Country(
    var name: String,
    var poblation: Int,
    var flag: Int?,
    var PIB: Int,
    var PIBPerHab: Float = -1F
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(String::class.java.classLoader) as String,
        parcel.readInt(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt(),
        parcel.readFloat()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(poblation)
        parcel.writeValue(flag)
        parcel.writeInt(PIB)
        parcel.writeFloat(PIBPerHab)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Country> {
        override fun createFromParcel(parcel: Parcel): Country {
            return Country(parcel)
        }

        override fun newArray(size: Int): Array<Country?> {
            return arrayOfNulls(size)
        }
    }
}