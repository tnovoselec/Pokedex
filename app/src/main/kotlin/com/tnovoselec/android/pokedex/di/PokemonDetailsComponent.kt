package com.tnovoselec.android.pokedex.di

import com.tnovoselec.android.pokedex.activity.PokemonDetailsActivity
import com.tnovoselec.android.pokedex.di.scope.PokemonDetailsScope
import com.tnovoselec.android.pokedex.presenter.PokemonDetailsPresenter
import dagger.Component


@PokemonDetailsScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(PokemonDetailsModule::class))
public interface PokemonDetailsComponent {

    fun inject(pokemonDetailsActivity: PokemonDetailsActivity)

    fun pokemonDetailsPresenter(): PokemonDetailsPresenter
}
