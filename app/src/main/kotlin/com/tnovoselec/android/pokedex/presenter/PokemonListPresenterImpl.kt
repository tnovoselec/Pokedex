package com.tnovoselec.android.pokedex.presenter

import android.util.Log
import com.tnovoselec.android.pokedex.api.model.Pokemon
import com.tnovoselec.android.pokedex.business.PokemonClient
import com.tnovoselec.android.pokedex.business.PokemonConverter
import com.tnovoselec.android.pokedex.db.dao.PokemonDao
import com.tnovoselec.android.pokedex.db.model.PokemonDb
import com.tnovoselec.android.pokedex.ui.view.PokemonListView
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Func2
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class PokemonListPresenterImpl
@Inject constructor(
        private val pokemonConverter: PokemonConverter,
        private val pokemonClient: PokemonClient,
        private val pokemonDao: PokemonDao) : PokemonListPresenter {

    private var pokemonListView: PokemonListView? = null

    override fun takeView(pokemonListView: PokemonListView) {
        this.pokemonListView = pokemonListView
    }

    override fun getPokemons() {
        pokemonClient
                .getPokedex()
                .flatMap {
                    Observable.from(it.pokemon)
                }
                .map {
                    simplePokemon ->
                    getPokemonFromDb(simplePokemon.resource_uri)
                }
                .flatMap { it ->
                    val resource_uri = it.first
                    val pokemonDb = it.second
                    if (pokemonDb == PokemonDb.EMPTY) {
                        pokemonClient.getPokemon(resource_uri).doOnNext { insertPokemon(it) }
                    } else {
                        Observable.just(pokemonConverter.toPokemon(pokemonDb))
                    }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ onSuccess(it) }, { onError(it) }, { onCompleted() })
    }

    fun insertPokemon(pokemon: Pokemon): Observable<Pokemon> {
        pokemonDao.insertPokemon(pokemon.attack, pokemon.catch_rate, pokemon.created, pokemon.defense, pokemon.egg_cycles,
                pokemon.ev_yield, pokemon.exp, pokemon.growth_rate, pokemon.happiness, pokemon.height, pokemon.hp,
                pokemon.male_female_ratio, pokemon.modified, pokemon.name, pokemon.national_id, pokemon.resource_uri,
                pokemon.sp_atk, pokemon.sp_def, pokemon.species, pokemon.speed, pokemon.total, pokemon.types, pokemon.weight)
        return Observable.just(pokemon)
    }

    fun getPokemonFromDb(resource_uri: String): Pair<String, PokemonDb> {
        return Pair(resource_uri, pokemonDao.getPokemon(resource_uri).toBlocking().first())
    }

    fun onSuccess(pokemon: Pokemon) {
        pokemonListView?.addItem(pokemon)
    }

    fun onError(throwable: Throwable) {
        throwable.printStackTrace()
    }

    fun onCompleted() {
        Log.i("Completed", "s")
    }
}