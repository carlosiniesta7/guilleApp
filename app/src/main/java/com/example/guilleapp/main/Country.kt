package com.example.guilleapp.main

import android.os.Parcel
import android.os.Parcelable

data class Country(
    var name: String?,
    var poblation: Int,
    var flag: Int,
    var PIB: Int,
    var PIBPerHab: Float = -1F
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readFloat()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(poblation)
        parcel.writeInt(flag)
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