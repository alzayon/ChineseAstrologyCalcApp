package com.alexis.chineseastrology.presenter

import com.alexis.chineseastrology.lib.IStarCalculator
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroupSet

internal class ShowYearlyFlyingStarsPresenter(val starCalculator: IStarCalculator) : IShowYearlyFlyingStarsPresenter {
    override fun calculateYearlyFlyingStarGroup(year: Int): YearlyFlyingStarGroup {
        return YearlyFlyingStarGroupSet.determineYearSetForYear(year).getFlyingStarsGroup()
    }
}