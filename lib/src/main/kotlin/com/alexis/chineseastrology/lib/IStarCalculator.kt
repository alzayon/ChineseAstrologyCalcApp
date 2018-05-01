package com.alexis.chineseastrology.lib

import com.alexis.chineseastrology.lib.flyingstars.stars.IFlyingStar
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStar
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup

interface IStarCalculator {
    fun calculateYearlyFlyingStars(year: Int): YearlyFlyingStarGroup
    fun calculateMonthlyFlyingStars(month: Int, year: Int): MonthlyFlyingStarGroup
    fun calculateMonthFlyingStar(month: Int, year: Int): MonthlyFlyingStar
    fun getFlyingStarFromNumber(number: Int): IFlyingStar
}