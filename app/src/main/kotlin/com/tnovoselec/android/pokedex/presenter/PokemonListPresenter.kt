package com.tnovoselec.android.pokedex.presenter

import com.tnovoselec.android.pokedex.ui.view.PokemonListView


interface PokemonListPresenter {

    fun takeView(pokemonListView: PokemonListView)

    fun getPokemons()
}