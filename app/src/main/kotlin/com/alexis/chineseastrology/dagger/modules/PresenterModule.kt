package com.alexis.chineseastrology.dagger.modules

import com.alexis.chineseastrology.lib.IBdayCalculator
import com.alexis.chineseastrology.lib.IStarCalculator
import com.alexis.chineseastrology.presenter.*
import dagger.Module
import dagger.Provides

@Module
internal class PresenterModule {
    @Provides
    fun provideCalculateBirthdayPresenter(bdayCalculator: IBdayCalculator): ICalculateBirthdayPresenter {
        return CalculateBirthdayPresenter(bdayCalculator)
    }

    @Provides
    fun provideShowMonthlyFlyingStarsPresenter(starCalculator: IStarCalculator) : IShowMonthlyFlyingStarsPresenter {
        return ShowMonthlyFlyingStarsPresenter(starCalculator)
    }

    @Provides
    fun provideShowYearlyFlyingStarsPresenter(starCalculator: IStarCalculator) : IShowYearlyFlyingStarsPresenter {
        return ShowYearlyFlyingStarsPresenter(starCalculator)
    }

    @Provides
    fun provideDetermineCurrentPositionPresenter(starCalculator: IStarCalculator) : IDetermineCurrentPositionPresenter {
        return DetermineCurrentPositionPresenter(starCalculator)
    }
}