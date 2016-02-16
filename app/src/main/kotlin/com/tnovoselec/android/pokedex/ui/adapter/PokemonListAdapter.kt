package com.tnovoselec.android.pokedex.ui.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tnovoselec.android.pokedex.R
import com.tnovoselec.android.pokedex.api.model.Pokemon
import com.tnovoselec.android.pokedex.api.model.PokemonType
import java.util.*

public class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

    var pokemonList = ArrayList<Pokemon>()

    var pokemonClickedListener = { pokemon: Pokemon, view: View -> Unit }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PokemonViewHolder? {
        var view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder?, position: Int) {
        var pokemon = pokemonList[position]
        holder?.fillView(pokemon)
        holder?.itemView?.setOnClickListener {
            pokemonClickedListener.invoke(pokemon, holder?.itemView)
        }
    }

    override fun getItemCount() = pokemonList.size

    public fun addItem(pokemon: Pokemon) {
        pokemonList.add(pokemon)
        Collections.sort(pokemonList, comparator { firstPokemon, secondPokemon -> firstPokemon.national_id - secondPokemon.national_id })
        var index = pokemonList.indexOf(pokemon)
        notifyItemInserted(index)
        notifyItemRangeChanged(index, pokemonList.size - 1)
    }


    class PokemonViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val imageTemplate = "http://pokeapi.co/media/img/%d.png"
        fun fillView(pokemon: Pokemon) {
            var image = itemView.findViewById(R.id.pokemon_image) as ImageView
            var name = itemView.findViewById(R.id.pokemon_name) as TextView
            var firstTypeBg = itemView.findViewById(R.id.type_color_first)
            var secondTypeBg = itemView.findViewById(R.id.type_color_second)

            Glide.with(itemView.context).load(imageTemplate.format(pokemon.national_id)).into(image)
            name.text = pokemon.name
            val firstType = PokemonType.valueOf(pokemon.types[0].name?.toUpperCase()!!)
            firstTypeBg.setBackgroundColor(Color.parseColor(firstType.color))
            if (pokemon.types.size > 1) {
                val secondType = PokemonType.valueOf(pokemon.types[1].name?.toUpperCase()!!)
                secondTypeBg.setBackgroundColor(Color.parseColor(secondType.color))
                secondTypeBg.visibility = View.VISIBLE
            } else {
                secondTypeBg.visibility = View.GONE
            }
        }
    }

}