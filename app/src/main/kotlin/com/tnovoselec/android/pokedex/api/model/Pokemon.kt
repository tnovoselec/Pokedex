package com.tnovoselec.android.pokedex.api.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Pokemon(
        val abilities: List<Ability>,
        val attack: Int,
        val catch_rate: Int,
        val created: String?,
        val defense: Int,
        val egg_cycles: Int,
        val ev_yield: String?,
        val exp: Int,
        val growth_rate: String?,
        val happiness: Int,
        val height: String?,
        val hp: Int,
        val male_female_ratio: String?,
        val modified: String?,
        val name: String?,
        val national_id: Int,
        val resource_uri: String?,
        val sp_atk: Int,
        val sp_def: Int,
        val species: String?,
        val speed: Int,
        val total: Int,
        val types: List<Type>,
        val weight: String?) : Parcelable {

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeTypedList(abilities)
        dest?.writeInt(attack)
        dest?.writeInt(catch_rate)
        dest?.writeString(created)
        dest?.writeInt(defense)
        dest?.writeInt(egg_cycles)
        dest?.writeString(ev_yield)
        dest?.writeInt(exp)
        dest?.writeString(growth_rate)
        dest?.writeInt(happiness)
        dest?.writeString(height)
        dest?.writeInt(hp)
        dest?.writeString(male_female_ratio)
        dest?.writeString(modified)
        dest?.writeString(name)
        dest?.writeInt(national_id)
        dest?.writeString(resource_uri)
        dest?.writeInt(sp_atk)
        dest?.writeInt(sp_def)
        dest?.writeString(species)
        dest?.writeInt(speed)
        dest?.writeInt(total)
        dest?.writeTypedList(types)
        dest?.writeString(weight)
    }

    constructor(parcel: Parcel) : this(
            parcel.createTypedArrayList(Ability.CREATOR),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.createTypedArrayList(Type.CREATOR),
            parcel.readString())

    override fun describeContents(): Int {
        return 0
    }


    companion object {
        @JvmField final val CREATOR: Parcelable.Creator<Pokemon> = object : Parcelable.Creator<Pokemon> {
            override fun createFromParcel(source: Parcel): Pokemon {
                return Pokemon(source)
            }

            override fun newArray(size: Int): Array<Pokemon?> {
                return arrayOfNulls(size)
            }
        }
    }

}



