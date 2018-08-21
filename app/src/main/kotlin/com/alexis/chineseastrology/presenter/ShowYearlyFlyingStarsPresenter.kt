package com.alexis.chineseastrology.presenter

import com.alexis.chineseastrology.lib.IStarCalculator
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup

internal class ShowYearlyFlyingStarsPresenter(val starCalculator: IStarCalculator) : IShowYearlyFlyingStarsPresenter {
    override fun calculateYearlyFlyingStarGroup(year: Int): YearlyFlyingStarGroup {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}