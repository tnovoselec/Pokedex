package com.tnovoselec.android.pokedex.api.model

import android.os.Parcel
import android.os.Parcelable

data class Ability(val name: String?, val resource_uri: String?) : Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeString(resource_uri)
    }

    companion object {
        @JvmField final val CREATOR: Parcelable.Creator<Ability> = object : Parcelable.Creator<Ability> {
            override fun createFromParcel(source: Parcel): Ability {
                return Ability(source)
            }

            override fun newArray(size: Int): Array<Ability?> {
                return arrayOfNulls(size)
            }
        }
    }
}