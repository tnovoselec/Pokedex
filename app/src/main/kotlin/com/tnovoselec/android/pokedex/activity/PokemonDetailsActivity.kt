package com.tnovoselec.android.pokedex.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.tnovoselec.android.pokedex.R
import com.tnovoselec.android.pokedex.api.model.Pokemon
import com.tnovoselec.android.pokedex.api.model.PokemonType
import com.tnovoselec.android.pokedex.di.DaggerPokemonDetailsComponent
import com.tnovoselec.android.pokedex.di.PokemonDetailsModule
import com.tnovoselec.android.pokedex.presenter.PokemonDetailsPresenter
import com.tnovoselec.android.pokedex.ui.view.PokemonDetailsView
import javax.inject.Inject
import kotlin.properties.Delegates


class PokemonDetailsActivity : BaseActivity(), PokemonDetailsView {

    var toolbar: Toolbar by Delegates.notNull()
    var pokemonImage: ImageView by Delegates.notNull()
    var collapsingToolbarLayout: CollapsingToolbarLayout by Delegates.notNull()
    var pokemon: Pokemon? = null

    companion object {

        public var POKEMON = "POKEMON"

        fun createIntent(context: Context, pokemon: Pokemon): Intent {
            val intent = Intent(context, PokemonDetailsActivity::class.java)
            intent.putExtra(POKEMON, pokemon)
            return intent
        }
    }

    protected lateinit var presenter: PokemonDetailsPresenter
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        pokemon = intent.getParcelableExtra(POKEMON)
        pokemonImage = findViewById(R.id.pokemon_details_image) as ImageView
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar) as CollapsingToolbarLayout
        toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.title = pokemon?.name
        val firstType = PokemonType.valueOf(pokemon?.types?.get(0)?.name?.toUpperCase()!!)
        collapsingToolbarLayout.setBackgroundColor(Color.parseColor(firstType.color))
        setSupportActionBar(toolbar)

        val imageTemplate = "http://pokeapi.co/media/img/%d.png"
        Glide.with(this).load(imageTemplate.format(pokemon?.national_id)).into(pokemonImage)

        initializeInjector()
    }

    fun initializeInjector() {
        DaggerPokemonDetailsComponent.builder()
                .applicationComponent(getApplicationComponent())
                .pokemonDetailsModule(PokemonDetailsModule())
                .build().inject(this)
    }
}