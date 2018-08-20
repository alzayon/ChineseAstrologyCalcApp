package com.alexis.chineseastrology.dagger.modules.builders.screens

import android.view.View
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewKey
import com.alexis.chineseastrology.dagger.modules.PresenterModule
import com.alexis.chineseastrology.screens.ShowYearlyFlyingStarsScreen
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Subcomponent(modules = [PresenterModule::class])
internal interface ShowYearlyFlyingStarScreenSubcomponent : AndroidInjector<ShowYearlyFlyingStarsScreen> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ShowYearlyFlyingStarsScreen>()
}

@Module(subcomponents = [ShowYearlyFlyingStarScreenSubcomponent::class])
internal abstract class ShowYearlyFlyingStarsScreenBuilder {
    @Binds
    @IntoMap
    @ViewKey(ShowYearlyFlyingStarsScreen::class)
    abstract fun bindShowYearlyFlyingStarsScreen(builder: ShowYearlyFlyingStarScreenSubcomponent.Builder): AndroidInjector.Factory<out View>

}
