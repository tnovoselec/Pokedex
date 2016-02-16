package com.tnovoselec.android.pokedex.di

import com.tnovoselec.android.pokedex.PokedexApplication
import com.tnovoselec.android.pokedex.activity.BaseActivity
import com.tnovoselec.android.pokedex.api.PokemonApi
import com.tnovoselec.android.pokedex.business.PokemonClient
import com.tnovoselec.android.pokedex.business.PokemonConverter
import com.tnovoselec.android.pokedex.db.dao.PokemonDao
import com.tnovoselec.android.pokedex.router.Router
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class))
interface ApplicationComponent {
    fun inject(application: PokedexApplication)

    fun pokemonApi(): PokemonApi

    fun pokemonClient(): PokemonClient

    fun pokemonDao(): PokemonDao

    fun pokemonConverter() : PokemonConverter

    fun router(): Router
}