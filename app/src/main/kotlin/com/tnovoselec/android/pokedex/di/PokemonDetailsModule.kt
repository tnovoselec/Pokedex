package com.tnovoselec.android.pokedex.di

import com.tnovoselec.android.pokedex.di.scope.PokemonDetailsScope
import com.tnovoselec.android.pokedex.presenter.PokemonDetailsPresenter
import com.tnovoselec.android.pokedex.presenter.PokemonDetailsPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class PokemonDetailsModule {
    @Provides
    @PokemonDetailsScope
    fun providePokemonDetailsPresenter(pokemonDetailsPresenterImpl: PokemonDetailsPresenterImpl): PokemonDetailsPresenter {
        return pokemonDetailsPresenterImpl
    }
}