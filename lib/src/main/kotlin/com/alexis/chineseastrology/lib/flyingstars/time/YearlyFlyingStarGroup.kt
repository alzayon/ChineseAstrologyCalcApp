package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.stars.IFlyingStar

class YearlyFlyingStarGroup: BaseFlyingStarGroup {
    var year: Int = 0

    constructor(yearlyFlyingStars: Set<YearlyFlyingStar>) {
        doBasicStarValidation("year", yearlyFlyingStars)
        val distinctYear = yearlyFlyingStars.distinctBy { it.year }
        if (distinctYear.size > 1) {
            throw IllegalArgumentException("Please supply year stars that are for the same year.")
        }
        year = distinctYear.get(0).year
        setupFlyingStars(yearlyFlyingStars.toList())
    }

    fun giveAdvancedFlyingStarGroup(steps: Int, yearPassed: Int? = null):
            IFlyingStarGroup {
        var yearToUse = yearPassed
        if (yearPassed == null) {
            year++
            yearToUse = year
        }
        val yearlyFlyingStars = advanceFlyingStarsBySteps(steps, yearToUse!!)
        return YearlyFlyingStarGroup(yearlyFlyingStars)
    }

    fun giveRewoundFlyingStarGroup(steps: Int, yearPassed: Int? = null):
            IFlyingStarGroup {
        var yearToUse = yearPassed
        if (yearPassed == null) {
            year--
            yearToUse = year
        }
        val yearlyFlyingStars = rewindFlyingStarsBySteps(steps, yearToUse!!)
        return YearlyFlyingStarGroup(yearlyFlyingStars)
    }

    fun giveStartBoundary(year: Int): BoundaryYear {
        val boundary = MonthlyBoundary.BOUNDARY1
        val startMonth = boundary.month
        val startDay = boundary.day
        return BoundaryYear(year, startMonth, startDay)
    }

    fun giveEndBoundary(year: Int): BoundaryYear {
        val boundary = MonthlyBoundary.BOUNDARY12
        val endMonth = boundary.monthEnd
        val endDay = boundary.dayEnd
        return BoundaryYear(year + 1, endMonth, endDay)
    }

    private fun advanceFlyingStarsBySteps(steps: Int, yearToUse: Int = year):
            Set<YearlyFlyingStar> {
        val setOfStars = setOfFlyingStars()
        val newSetOfStars = setOfStars.map {
            val newFlyingStar = IFlyingStar.advanceByPosition(steps, it.giveStarPosition().flyingStar)
            val newStarPosition = it.giveStarPosition().copy(flyingStar = newFlyingStar)
            val yearlyFlyingStar = it as YearlyFlyingStar
            return@map yearlyFlyingStar.copy(starPosition = newStarPosition, year = yearToUse)
        }.toSet()
        return newSetOfStars
    }

    private fun rewindFlyingStarsBySteps(steps: Int, yearToUse: Int = year):
            Set<YearlyFlyingStar> {
        val setOfStars = setOfFlyingStars()
        val newSetOfStars = setOfStars.map {
            val newFlyingStar = IFlyingStar.rewindByPosition(steps, it.giveStarPosition().flyingStar)
            val newStarPosition = it.giveStarPosition().copy(flyingStar = newFlyingStar)
            val yearlyFlyingStar = it as YearlyFlyingStar
            return@map yearlyFlyingStar.copy(starPosition = newStarPosition, year = yearToUse)
        }.toSet()
        return newSetOfStars
    }

    class BoundaryYear(val year: Int, val month: Int, val day: Int)
}