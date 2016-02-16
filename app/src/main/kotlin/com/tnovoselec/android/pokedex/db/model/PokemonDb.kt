package com.tnovoselec.android.pokedex.db.model

import com.hannesdorfmann.sqlbrite.objectmapper.annotation.Column
import com.hannesdorfmann.sqlbrite.objectmapper.annotation.ObjectMappable

@ObjectMappable
public class PokemonDb {


    companion object {
        const val TABLE_NAME = "Pokemon"
        const val ATTACK = "attack"
        const val CATCH_RATE = "catch_rate"
        const val CREATED = "created"
        const val DEFENSE = "defense"
        const val EGG_CYCLES = "egg_cycles"
        const val EV_YIELD = "ev_yield"
        const val EXP = "exp"
        const val GROWTH_RATE = "growth_rate"
        const val HAPPINESS = "happiness"
        const val HEIGHT = "height"
        const val HP = "hp"
        const val MALE_FEMALE_RATIO = "male_female_ratio"
        const val MODIFIED = "modified"
        const val NAME = "name"
        const val NATIONAL_ID = "national_id"
        const val RESOURCE_URI = "resource_uri"
        const val SP_ATK = "sp_atk"
        const val SP_DEF = "sp_def"
        const val SPECIES = "species"
        const val SPEED = "speed"
        const val TOTAL = "total"
        const val TYPES = "types"
        const val WEIGHT = "weight"

        var EMPTY = PokemonDb()
    }

    //    var abilities: List<Ability>
    @Column(ATTACK)
    var attack: Int = 0

    @Column(CATCH_RATE)
    var catch_rate: Int = 0

    @Column(CREATED)
    var created: String? = null

    @Column(DEFENSE)
    var defense: Int = 0

    @Column(EGG_CYCLES)
    var egg_cycles: Int = 0

    @Column(EV_YIELD)
    var ev_yield: String? = null

    @Column(EXP)
    var exp: Int = 0

    @Column(GROWTH_RATE)
    var growth_rate: String? = null

    @Column(HAPPINESS)
    var happiness: Int = 0

    @Column(HEIGHT)
    var height: String? = null

    @Column(HP)
    var hp: Int = 0

    @Column(MALE_FEMALE_RATIO)
    var male_female_ratio: String? = null

    @Column(MODIFIED)
    var modified: String? = null

    @Column(NAME)
    var name: String? = null

    @Column(NATIONAL_ID)
    var national_id: Int = 0

    @Column(RESOURCE_URI)
    var resource_uri: String? = null

    @Column(SP_ATK)
    var sp_atk: Int = 0

    @Column(SP_DEF)
    var sp_def: Int = 0

    @Column(SPECIES)
    var species: String? = null

    @Column(SPEED)
    var speed: Int = 0

    @Column(TOTAL)
    var total: Int = 0

    @Column(TYPES)
    var types: String? = null

    @Column(WEIGHT)
    var weight: String? = null

}