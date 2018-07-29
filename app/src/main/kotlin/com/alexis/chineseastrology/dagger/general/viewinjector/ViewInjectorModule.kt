package com.alexis.chineseastrology.dagger.general.viewinjector

import android.view.View
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.Multibinds


@Module
abstract class ViewInjectorModule {
    @Multibinds
    abstract fun viewInjectorFactories(): Map<Class<out View>, AndroidInjector.Factory<out View>>
}

object ViewInjection {
    fun inject(view: View?) {
        view?.let {
            ((view as? IViewWithActivity)?.activity as? IHasViewInjector)?.viewInjector()?.let {
                it.inject(view)
            } ?: throw IllegalArgumentException("Activity has no HasViewInjector")
        } ?: throw IllegalArgumentException("View is null. Cannot inject")
    }
}