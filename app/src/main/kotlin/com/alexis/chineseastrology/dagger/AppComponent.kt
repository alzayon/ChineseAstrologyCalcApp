package com.alexis.chineseastrology.dagger

import android.app.Application
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewInjectorModule
import com.alexis.chineseastrology.dagger.modules.AppModule
import com.alexis.chineseastrology.dagger.modules.builders.MainActivityBuilder
import com.alexis.chineseastrology.dagger.modules.builders.screens.CalculateBirthdayScreenBuilder
import com.alexis.chineseastrology.dagger.scope.AppScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@Component(modules = [
    AndroidSupportInjectionModule::class,
    ViewInjectorModule::class,
    AppModule::class,
    MainActivityBuilder::class,
    CalculateBirthdayScreenBuilder::class
])
@AppScope
internal interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(app: Application)
}