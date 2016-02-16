package com.tnovoselec.android.pokedex.ui.view

import com.tnovoselec.android.pokedex.api.model.Pokemon
import com.tnovoselec.android.pokedex.db.model.PokemonDb


interface PokemonListView {

    fun showProgress();

    fun addItem(pokemon: Pokemon)
}