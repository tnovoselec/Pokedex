package com.tnovoselec.android.pokedex.di

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activity: Activity) {

    @Provides
    @ForActivity
    fun provideActivityContext(): Context {
        return activity;
    }

}