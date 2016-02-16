package com.tnovoselec.android.pokedex.db.dao

import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import com.hannesdorfmann.sqlbrite.dao.Dao
import com.hannesdorfmann.sqlbrite.dao.sql.select.SELECT
import com.hannesdorfmann.sqlbrite.dao.sql.table.CREATE_TABLE
import com.squareup.sqlbrite.BriteDatabase
import com.tnovoselec.android.pokedex.api.model.Type
import com.tnovoselec.android.pokedex.db.model.PokemonDb
import com.tnovoselec.android.pokedex.db.model.PokemonDb.Companion
import com.tnovoselec.android.pokedex.db.model.PokemonDbMapper
import rx.Observable
import javax.inject.Inject

class PokemonDao @Inject constructor() : Dao() {


    override fun createTable(database: SQLiteDatabase?) {
        CREATE_TABLE(PokemonDb.TABLE_NAME,
                Companion.ATTACK + " INTEGER",
                Companion.CATCH_RATE + " INTEGER",
                Companion.CREATED + " TEXT",
                Companion.DEFENSE + " INTEGER",
                Companion.EGG_CYCLES + " INTEGER",
                Companion.EV_YIELD + " TEXT",
                Companion.EXP + " INTEGER",
                Companion.GROWTH_RATE + " TEXT",
                Companion.HAPPINESS + " INTEGER",
                Companion.HEIGHT + " TEXT",
                Companion.HP + " INTEGER",
                Companion.MALE_FEMALE_RATIO + " TEXT",
                Companion.MODIFIED + " TEXT",
                Companion.NAME + " TEXT  PRIMARY KEY NOT NULL",
                Companion.NATIONAL_ID + " INTEGER",
                Companion.RESOURCE_URI + " TEXT",
                Companion.SP_ATK + " INTEGER",
                Companion.SP_DEF + " INTEGER",
                Companion.SPECIES + " TEXT",
                Companion.SPEED + " INTEGER",
                Companion.TOTAL + " INTEGER",
                Companion.TYPES + " INTEGER",
                Companion.WEIGHT + " TEXT"
        ).execute(database);
    }

    fun getPokemons() = {
        query(SELECT(Companion.ATTACK,
                Companion.CATCH_RATE,
                Companion.CREATED,
                Companion.DEFENSE,
                Companion.EGG_CYCLES,
                Companion.EV_YIELD,
                Companion.EXP,
                Companion.GROWTH_RATE,
                Companion.HAPPINESS,
                Companion.HEIGHT,
                Companion.HP,
                Companion.MALE_FEMALE_RATIO,
                Companion.MODIFIED,
                Companion.NAME,
                Companion.NATIONAL_ID,
                Companion.RESOURCE_URI,
                Companion.SP_ATK,
                Companion.SP_DEF,
                Companion.SPECIES,
                Companion.SPEED,
                Companion.TOTAL,
                Companion.TYPES,
                Companion.WEIGHT
        ).FROM(PokemonDb.TABLE_NAME)).run().mapToList { PokemonDbMapper.MAPPER }
    }

    fun getPokemon(resourceUri: String?): Observable<PokemonDb> {
        return query(SELECT(Companion.ATTACK,
                Companion.CATCH_RATE,
                Companion.CREATED,
                Companion.DEFENSE,
                Companion.EGG_CYCLES,
                Companion.EV_YIELD,
                Companion.EXP,
                Companion.GROWTH_RATE,
                Companion.HAPPINESS,
                Companion.HEIGHT,
                Companion.HP,
                Companion.MALE_FEMALE_RATIO,
                Companion.MODIFIED,
                Companion.NAME,
                Companion.NATIONAL_ID,
                Companion.RESOURCE_URI,
                Companion.SP_ATK,
                Companion.SP_DEF,
                Companion.SPECIES,
                Companion.SPEED,
                Companion.TOTAL,
                Companion.TYPES,
                Companion.WEIGHT
        ).FROM(PokemonDb.TABLE_NAME).WHERE(Companion.RESOURCE_URI + " LIKE '%" + resourceUri + "'")).run().mapToOneOrDefault(PokemonDbMapper.MAPPER, PokemonDb.EMPTY)
    }

    fun insertPokemon(attack: Int, catchRate: Int, created: String?, defense: Int, eggCycles: Int, evYield: String?,
                      exp: Int, growthRate: String?, happiness: Int, height: String?, hp: Int, maleFemaleRatio: String?,
                      modified: String?, name: String?, nationalId: Int, resourceUri: String?, spAtk: Int, spDef: Int,
                      species: String?, speed: Int, total: Int, types: List<Type>?, weight: String?): Observable<Long> {
        return insert(PokemonDb.TABLE_NAME, PokemonDbMapper.contentValues()
                .attack(attack)
                .catch_rate(catchRate)
                .created(created)
                .defense(defense)
                .egg_cycles(eggCycles)
                .ev_yield(evYield)
                .exp(exp)
                .growth_rate(growthRate)
                .happiness(happiness)
                .height(height)
                .hp(hp)
                .male_female_ratio(maleFemaleRatio)
                .modified(modified)
                .name(name)
                .national_id(nationalId)
                .resource_uri(resourceUri)
                .sp_atk(spAtk)
                .sp_def(spDef)
                .species(species)
                .speed(speed)
                .total(total)
                .types(types?.map { it.name }?.joinToString(separator = ";"))
                .weight(weight)
                .build(), SQLiteDatabase.CONFLICT_REPLACE)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
