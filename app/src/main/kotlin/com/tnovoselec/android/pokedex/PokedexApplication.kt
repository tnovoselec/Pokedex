package com.tnovoselec.android.pokedex

import android.app.Application
import com.tnovoselec.android.pokedex.di.ApplicationComponent
import com.tnovoselec.android.pokedex.di.ApplicationModule
import com.tnovoselec.android.pokedex.di.DaggerApplicationComponent


class PokedexApplication : Application() {
    var applicationComponent: ApplicationComponent? = null


    override fun onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    fun initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build();
    }

}