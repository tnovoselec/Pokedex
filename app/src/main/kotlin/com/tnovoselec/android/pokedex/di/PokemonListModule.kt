package com.tnovoselec.android.pokedex.di

import com.tnovoselec.android.pokedex.di.scope.PokemonListScope
import com.tnovoselec.android.pokedex.presenter.PokemonListPresenter
import com.tnovoselec.android.pokedex.presenter.PokemonListPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class PokemonListModule {
    @Provides
    @PokemonListScope
    fun providePokemonListPresenter(pokemonListPresenterImpl: PokemonListPresenterImpl) : PokemonListPresenter {
        return pokemonListPresenterImpl
    }
}