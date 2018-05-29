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

    fun giveAdvancedFlyingStarGroup(steps: Int, yearToUse: Int):
            IFlyingStarGroup {
        val yearlyFlyingStars = advanceFlyingStarsBySteps(steps, yearToUse)
        return YearlyFlyingStarGroup(yearlyFlyingStars)
    }

    fun giveRewoundFlyingStarGroup(steps: Int, yearToUse: Int):
            IFlyingStarGroup {
        val yearlyFlyingStars = rewindFlyingStarsBySteps(steps, yearToUse)
        return YearlyFlyingStarGroup(yearlyFlyingStars)
    }

    private fun advanceFlyingStarsBySteps(steps: Int, yearToUse: Int):
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

    private fun rewindFlyingStarsBySteps(steps: Int, yearToUse: Int):
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
}