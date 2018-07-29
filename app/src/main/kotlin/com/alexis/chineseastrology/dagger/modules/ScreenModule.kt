package com.alexis.chineseastrology.dagger.modules

import com.alexis.chineseastrology.lib.BdayCalculator
import com.alexis.chineseastrology.lib.IBdayCalculator
import dagger.Module
import dagger.Provides

@Module
internal class ScreenModule {
    @Provides
    fun provideBdayCalculator(): IBdayCalculator {
        return BdayCalculator()
    }
}