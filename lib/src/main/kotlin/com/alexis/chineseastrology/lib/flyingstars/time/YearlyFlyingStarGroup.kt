package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.stars.IFlyingStar
import com.alexis.chineseastrology.lib.general.CompassDirection

class YearlyFlyingStarGroup: IFlyingStarGroup {
    lateinit var northStar: YearlyFlyingStar
        private set
    lateinit var southStar: YearlyFlyingStar
        private set
    lateinit var eastStar: YearlyFlyingStar
        private set
    lateinit var westStar: YearlyFlyingStar
        private set
    lateinit var northEastStar: YearlyFlyingStar
        private set
    lateinit var southEastStar: YearlyFlyingStar
        private set
    lateinit var southWestStar: YearlyFlyingStar
        private set
    lateinit var northWestStar: YearlyFlyingStar
        private set
    lateinit var centerStar: YearlyFlyingStar
        private set

    var year: Int = 0

    constructor(yearlyFlyingStars: Set<YearlyFlyingStar>) {
        if (yearlyFlyingStars.size != 9) {
            throw IllegalArgumentException("Incomplete yearly flying stars supplied to constructor.")
        }

        val distinctStars = yearlyFlyingStars.distinctBy { it.starPosition.compassDirection }
        if (distinctStars.size != 9) {
            throw IllegalArgumentException("Duplicate yearly flying stars supplied to constructor.")
        }

        val distinctYear = yearlyFlyingStars.distinctBy { it.year }
        if (distinctYear.size > 1) {
            throw IllegalArgumentException("Please supply flying stars that are for the same year.")
        }
        year = distinctYear.get(0).year
        setupFlyingStars(distinctStars)
    }

    override fun advanceFlyingStarsBySteps(steps: Int, yearOrMonthToUse: Int): Set<YearlyFlyingStar> {
        val setOfStars = setOfFlyingStars()
        val newSetOfStars = setOfStars.map {
            val newFlyingStar = IFlyingStar.advanceByPosition(steps, it.starPosition.flyingStar)
            val newStarPosition = it.starPosition.copy(flyingStar = newFlyingStar)
            return@map it.copy(starPosition = newStarPosition, year = yearOrMonthToUse)
        }.toSet()
        return newSetOfStars
    }

    override fun advanceFlyingStarsByStepsWithYear(steps: Int, yearOrMonthToUse: Int): YearlyFlyingStarGroup {
        val yearlyFlyingStars = advanceFlyingStarsBySteps(steps, yearOrMonthToUse)
        return YearlyFlyingStarGroup(yearlyFlyingStars)
    }

    fun setOfFlyingStars(): Set<YearlyFlyingStar> {
        return setOf(northStar, northEastStar, eastStar, southEastStar,
                southStar, southWestStar, westStar, northWestStar,
                centerStar)
    }

    private fun setupFlyingStars(distinctStars: List<YearlyFlyingStar>) {
        northStar = findStarForPosition(distinctStars, CompassDirection.NORTH)
        northEastStar = findStarForPosition(distinctStars, CompassDirection.NORTHEAST)
        eastStar = findStarForPosition(distinctStars, CompassDirection.EAST)
        southEastStar = findStarForPosition(distinctStars, CompassDirection.SOUTHEAST)
        southStar = findStarForPosition(distinctStars, CompassDirection.SOUTH)
        southWestStar = findStarForPosition(distinctStars, CompassDirection.SOUTHWEST)
        westStar = findStarForPosition(distinctStars, CompassDirection.WEST)
        northWestStar = findStarForPosition(distinctStars, CompassDirection.NORTHWEST)
        centerStar = findStarForPosition(distinctStars, CompassDirection.CENTER)
    }

    private fun findStarForPosition(distinctStars: List<YearlyFlyingStar>,
                                    compassDirection: CompassDirection): YearlyFlyingStar {
        return distinctStars.find { it.starPosition.compassDirection == compassDirection }!!
    }
}