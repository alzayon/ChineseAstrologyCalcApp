package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.StarPosition
import com.alexis.chineseastrology.lib.flyingstars.stars.*
import com.alexis.chineseastrology.lib.general.CompassDirection
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


// NOTE
// 1st month  = Feb
// 12th month = Jan
// If month is 12, use the month set for the previous year
class MonthlyFlyingStarGroupSetTest {

    @Before
    fun setup() {}

    @Test
    fun `getMonthlyFlyingStars for January 2020`() {
        val month = 12
        val year = 2019
        val yearFor12thMonth = 2020

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        val monthlyFlyingStarExpected = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(month, yearFor12thMonth, StarPosition(CompassDirection.NORTH, MisfortuneStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearFor12thMonth, StarPosition(CompassDirection.NORTHEAST, QuarrelsomeStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearFor12thMonth, StarPosition(CompassDirection.EAST, BurglaryStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearFor12thMonth, StarPosition(CompassDirection.SOUTHEAST, WealthStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearFor12thMonth, StarPosition(CompassDirection.SOUTH, PeachBlossomStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearFor12thMonth, StarPosition(CompassDirection.SOUTHWEST, HeavenStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearFor12thMonth, StarPosition(CompassDirection.WEST, IllnessStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearFor12thMonth, StarPosition(CompassDirection.NORTHWEST, VictoryStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearFor12thMonth, StarPosition(CompassDirection.CENTER, FutureProsperityStar()), yearlyGroup.giveCenterStar().giveStarPosition())
                )
        )

        val monthlyFlyingStarsActual = MonthlyFlyingStarGroupSet.getMonthlyFlyingStars(month, year)

        Assert.assertNotNull(monthlyFlyingStarsActual)
        Assert.assertEquals(monthlyFlyingStarExpected, monthlyFlyingStarsActual)

    }

    @After
    fun tearDown() {}
}