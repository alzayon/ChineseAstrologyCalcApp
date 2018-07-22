package com.alexis.chineseastrology

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import com.alexis.chineseastrology.dagger.DaggerAppComponent

internal class ChastroApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().build()
    }
}