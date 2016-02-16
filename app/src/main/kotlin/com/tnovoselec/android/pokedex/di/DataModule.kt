package com.tnovoselec.android.pokedex.di

import android.content.Context
import com.google.gson.Gson
import com.hannesdorfmann.sqlbrite.dao.DaoManager
import com.tnovoselec.android.pokedex.api.PokemonApi
import com.tnovoselec.android.pokedex.business.PokemonClient
import com.tnovoselec.android.pokedex.db.dao.PokemonDao
import dagger.Module
import dagger.Provides
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }


    @Provides
    @Singleton
    fun providePokemonApi(): PokemonApi {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        val pokemonApi = retrofit.create(PokemonApi::class.java)
        return pokemonApi
    }

    @Provides
    @Singleton
    fun providePokemonClient(pokemonApi: PokemonApi): PokemonClient {
        var pokemonClient = PokemonClient(pokemonApi)
        return pokemonClient
    }

    @Provides
    @Singleton
    fun providePokemonDao(@ForApplication context: Context): PokemonDao{
        val pokemonDao = PokemonDao()
        val daoManager = DaoManager(context, "pokedex.db", 1, pokemonDao)
        return pokemonDao
    }
}