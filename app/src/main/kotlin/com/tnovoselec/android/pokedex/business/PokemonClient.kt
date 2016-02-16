package com.tnovoselec.android.pokedex.business

import com.tnovoselec.android.pokedex.api.PokemonApi
import com.tnovoselec.android.pokedex.api.model.Pokedex
import com.tnovoselec.android.pokedex.api.model.Pokemon
import rx.Observable
import javax.inject.Inject

class PokemonClient @Inject constructor(val pokemonApi: PokemonApi) {

    public fun getPokedex(): Observable<Pokedex> {
        return pokemonApi.getPokedex()
    }

    public fun getPokemon(resource_uri: String?) : Observable<Pokemon>{
        return pokemonApi.getPokemon(resource_uri)
    }
}
