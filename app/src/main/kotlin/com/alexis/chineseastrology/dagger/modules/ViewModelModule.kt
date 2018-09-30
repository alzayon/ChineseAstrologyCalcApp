package com.alexis.chineseastrology.dagger.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.alexis.chineseastrology.dagger.general.ViewModelKey
import com.alexis.chineseastrology.general.ViewModelFactory
import com.alexis.chineseastrology.viewmodel.CalculateBirthdayViewModel
import com.alexis.chineseastrology.viewmodel.DetermineCurrentPositionViewModel
import com.alexis.chineseastrology.viewmodel.ShowMonthlyFlyingStarsViewModel
import com.alexis.chineseastrology.viewmodel.ShowYearlyFlyingStarsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CalculateBirthdayViewModel::class)
    internal abstract fun bindCalculateBirthdayViewModel(calculateBirthdayViewModel: CalculateBirthdayViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetermineCurrentPositionViewModel::class)
    internal abstract fun bindDetermineCurrentPositionViewModel(determineCurrentPositionViewModel: DetermineCurrentPositionViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShowMonthlyFlyingStarsViewModel::class)
    internal abstract fun bindShowMonthlyFlyingStarsViewModel(showMonthlyFlyingStarsViewModel: ShowMonthlyFlyingStarsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShowYearlyFlyingStarsViewModel::class)
    internal abstract fun bindShowYearlyMonthlyStarsViewModel(calculateBirthdayViewModel: CalculateBirthdayViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}