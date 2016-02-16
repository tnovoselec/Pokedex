package com.tnovoselec.android.pokedex.business

import com.tnovoselec.android.pokedex.api.model.Pokemon
import com.tnovoselec.android.pokedex.api.model.Type
import com.tnovoselec.android.pokedex.db.model.PokemonDb
import java.util.*
import javax.inject.Inject


class PokemonConverter @Inject constructor() {

    fun toPokemon(pokemonDb: PokemonDb): Pokemon {
        return Pokemon(ArrayList(), pokemonDb.attack, pokemonDb.catch_rate, pokemonDb.created, pokemonDb.defense,
                pokemonDb.egg_cycles, pokemonDb.ev_yield, pokemonDb.exp, pokemonDb.growth_rate, pokemonDb.happiness, pokemonDb.height,
                pokemonDb.hp, pokemonDb.male_female_ratio, pokemonDb.modified, pokemonDb.name, pokemonDb.national_id, pokemonDb.resource_uri,
                pokemonDb.sp_atk, pokemonDb.sp_def, pokemonDb.species, pokemonDb.speed, pokemonDb.total, toTypes(pokemonDb.types), pokemonDb.weight)
    }

    fun toTypes(types: String?): List<Type> {
        return types?.split(";")?.map { Type(it, "") }?.toList()!!
    }
}