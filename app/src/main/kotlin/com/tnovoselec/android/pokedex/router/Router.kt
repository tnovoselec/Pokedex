package com.tnovoselec.android.pokedex.router

import android.content.Context
import android.view.View
import com.tnovoselec.android.pokedex.activity.PokemonDetailsActivity
import com.tnovoselec.android.pokedex.api.model.Pokemon
import javax.inject.Inject


class Router @Inject constructor() {

    fun startPokemonDetailsActivity(context: Context, pokemon: Pokemon, view: View){
        var intent = PokemonDetailsActivity.createIntent(context, pokemon)
        context.startActivity(intent)
    }
}