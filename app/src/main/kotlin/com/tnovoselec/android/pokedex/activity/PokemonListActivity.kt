package com.tnovoselec.android.pokedex.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import com.tnovoselec.android.pokedex.R
import com.tnovoselec.android.pokedex.api.model.Pokemon
import com.tnovoselec.android.pokedex.di.DaggerPokemonListComponent
import com.tnovoselec.android.pokedex.di.PokemonListModule
import com.tnovoselec.android.pokedex.presenter.PokemonListPresenter
import com.tnovoselec.android.pokedex.router.Router
import com.tnovoselec.android.pokedex.ui.adapter.PokemonListAdapter
import com.tnovoselec.android.pokedex.ui.supplementary.OffsetItemDecoration
import com.tnovoselec.android.pokedex.ui.view.PokemonListView
import javax.inject.Inject
import kotlin.properties.Delegates


class PokemonListActivity : BaseActivity(), PokemonListView {

    protected lateinit var presenter: PokemonListPresenter
        @Inject set

    protected lateinit var router: Router
        @Inject set

    var recycler: RecyclerView by Delegates.notNull()
    var toolbar: Toolbar by Delegates.notNull()
    var adapter: PokemonListAdapter = PokemonListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        initializeInjector()

        toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)

        recycler = findViewById(R.id.recycler) as RecyclerView
        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.addItemDecoration(OffsetItemDecoration(R.dimen.grid_spacing))
        recycler.adapter = adapter
        adapter.pokemonClickedListener = { pokemon, view -> onPokemonClicked(pokemon, view) }

        presenter.takeView(this)
        presenter.getPokemons()
    }

    private fun onPokemonClicked(pokemon: Pokemon, view: View) {
        router.startPokemonDetailsActivity(this, pokemon, view)
    }

    override fun addItem(pokemon: Pokemon) {
        adapter.addItem(pokemon)
    }

    override fun showProgress() {

    }

    fun initializeInjector() {
        DaggerPokemonListComponent.builder()
                .applicationComponent(getApplicationComponent())
                .pokemonListModule(PokemonListModule())
                .build().inject(this)
    }
}