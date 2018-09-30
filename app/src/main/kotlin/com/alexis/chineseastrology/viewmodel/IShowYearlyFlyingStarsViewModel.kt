package com.alexis.chineseastrology.viewmodel

import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup

interface IShowYearlyFlyingStarsViewModel {
    fun calculateYearlyFlyingStarGroup(year: Int): YearlyFlyingStarGroup
}