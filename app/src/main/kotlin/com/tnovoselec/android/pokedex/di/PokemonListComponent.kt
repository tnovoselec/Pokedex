package com.tnovoselec.android.pokedex.di

import com.tnovoselec.android.pokedex.activity.PokemonListActivity
import com.tnovoselec.android.pokedex.di.scope.PokemonListScope
import com.tnovoselec.android.pokedex.presenter.PokemonListPresenter
import dagger.Component


@PokemonListScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(PokemonListModule::class))
public interface PokemonListComponent {

    fun inject(pokemonListActivity: PokemonListActivity)

    fun pokemonListPresenter(): PokemonListPresenter
}
