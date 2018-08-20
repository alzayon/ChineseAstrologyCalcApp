package com.alexis.chineseastrology.dagger.modules

import com.alexis.chineseastrology.lib.BdayCalculator
import com.alexis.chineseastrology.lib.IBdayCalculator
import com.alexis.chineseastrology.lib.IStarCalculator
import com.alexis.chineseastrology.lib.StarCalculator
import dagger.Module
import dagger.Provides

@Module
internal class CalculatorModule {
    @Provides
    fun provideBdayCalculator(): IBdayCalculator {
        return BdayCalculator()
    }

    @Provides
    fun provideStarCalculator(): IStarCalculator {
        return StarCalculator()
    }
}