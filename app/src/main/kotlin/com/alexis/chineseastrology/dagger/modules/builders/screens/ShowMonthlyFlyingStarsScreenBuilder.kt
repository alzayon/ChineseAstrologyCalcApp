package com.alexis.chineseastrology.dagger.modules.builders.screens

import android.view.View
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewKey
import com.alexis.chineseastrology.dagger.modules.ViewModelModule
import com.alexis.chineseastrology.screens.ShowMonthlyFlyingStarsScreen
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Subcomponent
internal interface ShowMonthlyFlyingStarsScreenSubcomponent : AndroidInjector<ShowMonthlyFlyingStarsScreen> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ShowMonthlyFlyingStarsScreen>()
}

@Module(subcomponents = [ShowMonthlyFlyingStarsScreenSubcomponent::class])
internal abstract class ShowMonthlyFlyingStarScreenBuilder {
    @Binds
    @IntoMap
    @ViewKey(ShowMonthlyFlyingStarsScreen::class)
    abstract fun bindShowMonthlyFlyingStarsScreen(builder: ShowMonthlyFlyingStarsScreenSubcomponent.Builder) :
            AndroidInjector.Factory<out View>
}