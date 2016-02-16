package com.tnovoselec.android.pokedex.di

import android.app.Activity
import com.tnovoselec.android.pokedex.activity.BaseActivity
import com.tnovoselec.android.pokedex.activity.PokemonListActivity
import com.tnovoselec.android.pokedex.di.scope.ActivityScope
import dagger.Component


@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
public interface ActivityComponent {


}