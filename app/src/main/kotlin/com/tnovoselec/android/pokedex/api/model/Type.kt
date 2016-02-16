package com.tnovoselec.android.pokedex.api.model

import android.os.Parcel
import android.os.Parcelable

data class Type(val name: String?, val  resource_uri: String?) : Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeString(resource_uri)
    }

    companion object {
        @JvmField final val CREATOR: Parcelable.Creator<Type> = object : Parcelable.Creator<Type> {
            override fun createFromParcel(source: Parcel): Type {
                return Type(source)
            }

            override fun newArray(size: Int): Array<Type?> {
                return arrayOfNulls(size)
            }
        }
    }
}