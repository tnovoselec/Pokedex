package com.tnovoselec.android.pokedex.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tnovoselec.android.pokedex.PokedexApplication
import com.tnovoselec.android.pokedex.di.ActivityComponent
import com.tnovoselec.android.pokedex.di.ActivityModule
import com.tnovoselec.android.pokedex.di.ApplicationComponent
import com.tnovoselec.android.pokedex.di.DaggerActivityComponent
import kotlin.properties.Delegates


open class BaseActivity : AppCompatActivity() {

    var activityComponent : ActivityComponent by Delegates.notNull()

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder().applicationComponent(getApplicationComponent()).activityModule(getActivityModule()).build()
    }

    fun getApplicationComponent(): ApplicationComponent? {
        return (application as PokedexApplication).applicationComponent;
    }

    fun getActivityModule(): ActivityModule {
        return ActivityModule(this);
    }
}