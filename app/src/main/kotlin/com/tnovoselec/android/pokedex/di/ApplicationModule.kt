package com.tnovoselec.android.pokedex.di

import android.app.Application
import android.content.Context
import com.tnovoselec.android.pokedex.router.Router
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule(val application: Application) {

    @Provides
    @ForApplication
    fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    @ForApplication
    fun provideRouter(): Router {
        return Router()
    }
}