package com.tnovoselec.android.pokedex.api

import com.tnovoselec.android.pokedex.api.model.Pokedex
import com.tnovoselec.android.pokedex.api.model.Pokemon
import retrofit.http.GET
import retrofit.http.Path
import rx.Observable


interface PokemonApi {
    @GET("/api/v1/pokedex/1/")
    fun getPokedex() : Observable<Pokedex>

    @GET("{path}")
    fun getPokemon(@Path("path") resource_uri: String?) : Observable<Pokemon>
}