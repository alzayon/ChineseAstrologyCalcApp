package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.StarPosition

data class MonthlyFlyingStar(val month: Int,
                             val year: Int,
                             val starPosition: StarPosition,
                             val yearlyStarPosition: StarPosition): ITimeFlyingStar {
    override fun giveStarPosition(): StarPosition {
        return starPosition
    }

    fun giveYearlyStarPosition(): StarPosition {
        return yearlyStarPosition
    }
}