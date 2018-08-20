package com.alexis.chineseastrology.dagger.modules.builders.screens

import android.view.View
import com.alexis.chineseastrology.dagger.general.viewinjector.ViewKey
import com.alexis.chineseastrology.dagger.modules.PresenterModule
import com.alexis.chineseastrology.screens.CalculateBirthdayScreen
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap


@Subcomponent(modules = [PresenterModule::class])
internal interface CalculateBirthdayScreenSubcomponent : AndroidInjector<CalculateBirthdayScreen> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<CalculateBirthdayScreen>()
}

@Module(subcomponents = [CalculateBirthdayScreenSubcomponent::class])
internal abstract class CalculateBirthdayScreenBuilder {
    @Binds
    @IntoMap
    @ViewKey(CalculateBirthdayScreen::class)
    abstract fun bindCalculateBirthdayScreen(builder: CalculateBirthdayScreenSubcomponent.Builder): AndroidInjector.Factory<out View>
}
