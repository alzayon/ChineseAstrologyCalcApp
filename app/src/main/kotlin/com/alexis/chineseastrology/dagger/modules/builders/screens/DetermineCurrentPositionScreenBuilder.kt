package com.alexis.chineseastrology.dagger.modules.builders.screens

import android.view.View
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewKey
import com.alexis.chineseastrology.dagger.modules.PresenterModule
import com.alexis.chineseastrology.screens.DetermineCurrentPositionScreen
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Subcomponent(modules = [PresenterModule::class])
internal interface DetermineCurrentPositionScreenSubcomponent : AndroidInjector<DetermineCurrentPositionScreen> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DetermineCurrentPositionScreen>()
}

@Module(subcomponents = [DetermineCurrentPositionScreenSubcomponent::class])
internal abstract class DetermineCurrentPositionScreenBuilder {
    @Binds
    @IntoMap
    @ViewKey(DetermineCurrentPositionScreen::class)
    abstract fun bindDetermineCurrentPositionScreen(builder: DetermineCurrentPositionScreenSubcomponent.Builder) :
            AndroidInjector.Factory<out View>
}