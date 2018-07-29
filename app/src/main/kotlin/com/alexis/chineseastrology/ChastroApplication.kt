package com.alexis.chineseastrology

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import com.alexis.chineseastrology.dagger.DaggerAppComponent
import timber.log.Timber
import timber.log.Timber.DebugTree



internal class ChastroApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
        Timber.tag("ChineseAstrology")
    }
}