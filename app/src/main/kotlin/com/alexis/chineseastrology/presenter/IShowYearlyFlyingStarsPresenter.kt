package com.alexis.chineseastrology.presenter

import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup

interface IShowYearlyFlyingStarsPresenter {
    fun calculateYearlyFlyingStarGroup(year: Int): YearlyFlyingStarGroup
}