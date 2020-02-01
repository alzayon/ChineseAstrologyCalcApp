package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.StarPosition
import com.alexis.chineseastrology.lib.flyingstars.stars.*
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroupSet.Companion.BASE_YEAR
import com.alexis.chineseastrology.lib.general.CompassDirection
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MonthlyFlyingStarGroupTest {

    private var monthlyFlyingStarGroup:MonthlyFlyingStarGroup? = null

    @Before
    fun setup() {
        monthlyFlyingStarGroup = MonthlyFlyingStarGroupSet.giveMonthlyFlyingStarGroupFirstMonthSet1()
    }

    @Test
    fun `giveAdvancedFlyingStarGroup() happy path same year`() {
        val steps = 3
        val month = 4
        val year = 2013
        val monthlyFlyingStarGroupAdvanced =
                monthlyFlyingStarGroup?.giveAdvancedFlyingStarGroup(steps)

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
            setOf(
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, PeachBlossomStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, IllnessStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, HeavenStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, BurglaryStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, QuarrelsomeStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, MisfortuneStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, VictoryStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, FutureProsperityStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, WealthStar()), yearlyGroup.giveCenterStar().giveStarPosition())
            )
        )
        assertNotNull(monthlyFlyingStarGroupAdvanced)
        assertEquals(expected, monthlyFlyingStarGroupAdvanced)
    }

    @Test
    fun `giveRewoundFlyingStarGroup happy path same year`() {
        val steps = 2
        val month = 5
        val year = 2013

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
            setOf(
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, QuarrelsomeStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, VictoryStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, MisfortuneStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, HeavenStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, IllnessStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, PeachBlossomStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, FutureProsperityStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, WealthStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, BurglaryStar()), yearlyGroup.giveCenterStar().giveStarPosition())
            )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)

        val monthExpected = 3

        val expected = MonthlyFlyingStarGroup(
            setOf(
                MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.NORTH, MisfortuneStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.NORTHEAST, QuarrelsomeStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.EAST, BurglaryStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.SOUTHEAST, WealthStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.SOUTH, PeachBlossomStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.SOUTHWEST, HeavenStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.WEST, IllnessStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.NORTHWEST, VictoryStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.CENTER, FutureProsperityStar()), yearlyGroup.giveCenterStar().giveStarPosition())
            )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }


    @Test
    fun `giveAdvancedFlyingStarGroup() start in first month, overflow of one year`() {
        val steps = 17
        val month = 6
        val year = 2014

        val monthlyFlyingStarGroupAdvanced =
                monthlyFlyingStarGroup?.giveAdvancedFlyingStarGroup(steps)

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
            setOf(
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, WealthStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, HeavenStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, VictoryStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, IllnessStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, BurglaryStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, FutureProsperityStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, MisfortuneStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, PeachBlossomStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, QuarrelsomeStar()), yearlyGroup.giveCenterStar().giveStarPosition())
            )
        )
        assertNotNull(monthlyFlyingStarGroupAdvanced)
        assertEquals(expected, monthlyFlyingStarGroupAdvanced)
    }


    @Test
    fun `giveRewoundFlyingStarGroup start in first month, backflow of one year`() {
        val steps = 3
        val month = 10
        val year = 2012

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
            setOf(
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, VictoryStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, WealthStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, QuarrelsomeStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, PeachBlossomStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, FutureProsperityStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, IllnessStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, BurglaryStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, HeavenStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, MisfortuneStar()), yearlyGroup.giveCenterStar().giveStarPosition())
            )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }


    @Test
    fun `giveAdvancedFlyingStarGroup start in fifth month, overflow of one year`() {
        val steps = 10
        val month = 5
        val year = 2013

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
            setOf(
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, QuarrelsomeStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, VictoryStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, MisfortuneStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, HeavenStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, IllnessStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, PeachBlossomStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, FutureProsperityStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, WealthStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, BurglaryStar()), yearlyGroup.giveCenterStar().giveStarPosition())
            )
        )

        val monthlyFlyingStarGroupAdvanced =
                monthlyFlyingStarGroup?.giveAdvancedFlyingStarGroup(steps)

        val monthExpected = 3
        val yearExpected = 2014

        val expectedYearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(yearExpected)
        val expectedFlyingStarGroup = expectedYearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
            setOf(
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTH, IllnessStar()), expectedFlyingStarGroup.giveNorthStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHEAST, FutureProsperityStar()), expectedFlyingStarGroup.giveNorthEastStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.EAST, PeachBlossomStar()), expectedFlyingStarGroup.giveEastStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHEAST, MisfortuneStar()), expectedFlyingStarGroup.giveSouthEastStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTH, VictoryStar()), expectedFlyingStarGroup.giveSouthStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHWEST, QuarrelsomeStar()), expectedFlyingStarGroup.giveSouthWestStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.WEST, WealthStar()), expectedFlyingStarGroup.giveWestStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHWEST, BurglaryStar()), expectedFlyingStarGroup.giveNorthWestStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.CENTER, HeavenStar()), expectedFlyingStarGroup.giveCenterStar().giveStarPosition())
            )
        )
        assertNotNull(monthlyFlyingStarGroupAdvanced)
        assertEquals(expected, monthlyFlyingStarGroupAdvanced)
    }


    @Test
    fun `giveRewoundFlyingStarGroup start in fifth month, backflow of one year`() {
        val steps = 10
        val month = 5
        val year = 2013

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
            setOf(
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, QuarrelsomeStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, VictoryStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, MisfortuneStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, HeavenStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, IllnessStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, PeachBlossomStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, FutureProsperityStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, WealthStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, BurglaryStar()), yearlyGroup.giveCenterStar().giveStarPosition())
            )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)

        val monthExpected = 7
        val yearExpected = 2012

        val expectedYearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(yearExpected)
        val expectedFlyingStarGroup = expectedYearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
            setOf(
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTH, PeachBlossomStar()), expectedFlyingStarGroup.giveNorthStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHEAST, IllnessStar()), expectedFlyingStarGroup.giveNorthEastStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.EAST, HeavenStar()), expectedFlyingStarGroup.giveEastStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHEAST, BurglaryStar()), expectedFlyingStarGroup.giveSouthEastStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTH, QuarrelsomeStar()), expectedFlyingStarGroup.giveSouthStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHWEST, MisfortuneStar()), expectedFlyingStarGroup.giveSouthWestStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.WEST, VictoryStar()), expectedFlyingStarGroup.giveWestStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHWEST, FutureProsperityStar()), expectedFlyingStarGroup.giveNorthWestStar().giveStarPosition()),
                MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.CENTER, WealthStar()), expectedFlyingStarGroup.giveCenterStar().giveStarPosition())
            )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }


    @Test
    fun `giveAdvancedFlyingStarGroup() start in first month overflow of two years`() {
        val steps = 28
        val month = 5
        val year = 2015

        val expectedYearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val expectedFlyingStarGroup = expectedYearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, HeavenStar()), expectedFlyingStarGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, PeachBlossomStar()), expectedFlyingStarGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, WealthStar()), expectedFlyingStarGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, FutureProsperityStar()), expectedFlyingStarGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, MisfortuneStar()), expectedFlyingStarGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, BurglaryStar()), expectedFlyingStarGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, QuarrelsomeStar()), expectedFlyingStarGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, IllnessStar()), expectedFlyingStarGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, VictoryStar()), expectedFlyingStarGroup.giveCenterStar().giveStarPosition())
                )
        )

        val monthlyFlyingStarGroupAdvanced =
                monthlyFlyingStarGroup?.giveAdvancedFlyingStarGroup(steps)

        assertNotNull(monthlyFlyingStarGroupAdvanced)
        assertEquals(expected, monthlyFlyingStarGroupAdvanced)
    }

    @Test
    fun `giveRewoundFlyingStarGroup() start in first month backflow of three years`() {
        val steps = 28
        val month = 9
        val year = 2010

        val monthlyFlyingStarGroupAdvanced =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)

        val expectedYearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val expectedFlyingStarGroup = expectedYearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, WealthStar()), expectedFlyingStarGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, HeavenStar()), expectedFlyingStarGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, VictoryStar()), expectedFlyingStarGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, IllnessStar()), expectedFlyingStarGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, BurglaryStar()), expectedFlyingStarGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, FutureProsperityStar()), expectedFlyingStarGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, MisfortuneStar()), expectedFlyingStarGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, PeachBlossomStar()), expectedFlyingStarGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, QuarrelsomeStar()), expectedFlyingStarGroup.giveCenterStar().giveStarPosition())
                )
        )
        assertNotNull(monthlyFlyingStarGroupAdvanced)
        assertEquals(expected, monthlyFlyingStarGroupAdvanced)
    }


    @Test
    fun `giveAdvanceFlyingStars start in 6th month, overflow of 3 years`() {
        val steps = 31
        val month = 6
        val year = 2013

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, IllnessStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, FutureProsperityStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, PeachBlossomStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, MisfortuneStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, VictoryStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, QuarrelsomeStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, WealthStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, BurglaryStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, HeavenStar()), yearlyGroup.giveCenterStar().giveStarPosition())
                )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveAdvancedFlyingStarGroup(steps)


        val monthExpected = 1
        val yearExpected = 2016

        val expectedYearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(yearExpected)
        val expectedFlyingStarGroup = expectedYearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTH, BurglaryStar()), expectedFlyingStarGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHEAST, MisfortuneStar()), expectedFlyingStarGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.EAST, FutureProsperityStar()), expectedFlyingStarGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHEAST, VictoryStar()), expectedFlyingStarGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTH, HeavenStar()), expectedFlyingStarGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHWEST, WealthStar()), expectedFlyingStarGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.WEST, PeachBlossomStar()), expectedFlyingStarGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHWEST, QuarrelsomeStar()), expectedFlyingStarGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.CENTER, IllnessStar()), expectedFlyingStarGroup.giveCenterStar().giveStarPosition())
                )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }


    @Test
    fun `giveRewoundFlyingStarGroup start in the fifth month, backflow of three years`() {
        val steps = 30
        val month = 5
        val year = 2013

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, QuarrelsomeStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, VictoryStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, MisfortuneStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, HeavenStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, IllnessStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, PeachBlossomStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, FutureProsperityStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, WealthStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, BurglaryStar()), yearlyGroup.giveCenterStar().giveStarPosition())
                )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)


        val monthExpected = 11
        val yearExpected = 2010

        val expectedYearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(yearExpected)
        val expectedFlyingStarGroup = expectedYearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTH, HeavenStar()), expectedFlyingStarGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHEAST, PeachBlossomStar()), expectedFlyingStarGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.EAST, WealthStar()), expectedFlyingStarGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHEAST, FutureProsperityStar()), expectedFlyingStarGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTH, MisfortuneStar()), expectedFlyingStarGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHWEST, BurglaryStar()), expectedFlyingStarGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.WEST, QuarrelsomeStar()), expectedFlyingStarGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHWEST, IllnessStar()), expectedFlyingStarGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.CENTER, VictoryStar()), expectedFlyingStarGroup.giveCenterStar().giveStarPosition())
                )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }


    @Test
    fun `giveAdvanceFlyingStars start in 12th month, overflow of 2 years`() {
        val steps = 17
        val month = 12
        val year = 2013

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, MisfortuneStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, QuarrelsomeStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, BurglaryStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, WealthStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, PeachBlossomStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, HeavenStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, IllnessStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, VictoryStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, FutureProsperityStar()), yearlyGroup.giveCenterStar().giveStarPosition())
                )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveAdvancedFlyingStarGroup(steps)


        val monthExpected = 5
        val yearExpected = 2015

        val expectedYearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(yearExpected)
        val expectedFlyingStarGroup = expectedYearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTH, HeavenStar()), expectedFlyingStarGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHEAST, PeachBlossomStar()), expectedFlyingStarGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.EAST, WealthStar()), expectedFlyingStarGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHEAST, FutureProsperityStar()), expectedFlyingStarGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTH, MisfortuneStar()), expectedFlyingStarGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHWEST, BurglaryStar()), expectedFlyingStarGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.WEST, QuarrelsomeStar()), expectedFlyingStarGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHWEST, IllnessStar()), expectedFlyingStarGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.CENTER, VictoryStar()), expectedFlyingStarGroup.giveCenterStar().giveStarPosition())
                )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }


    @Test
    fun `giveRewoundFlyingStars start in 12th month, backflow of 2 years`() {
        val steps = 26
        val month = 12
        val year = 2013

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, MisfortuneStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, QuarrelsomeStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, BurglaryStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, WealthStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, PeachBlossomStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, HeavenStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, IllnessStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, VictoryStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, FutureProsperityStar()), yearlyGroup.giveCenterStar().giveStarPosition())
                )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)

        val monthExpected = 10
        val yearExpected = 2011

        val expectedYearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(yearExpected)
        val expectedFlyingStarGroup = expectedYearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTH, PeachBlossomStar()), expectedFlyingStarGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHEAST, IllnessStar()), expectedFlyingStarGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.EAST, HeavenStar()), expectedFlyingStarGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHEAST, BurglaryStar()), expectedFlyingStarGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTH, QuarrelsomeStar()), expectedFlyingStarGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHWEST, MisfortuneStar()), expectedFlyingStarGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.WEST, VictoryStar()), expectedFlyingStarGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHWEST, FutureProsperityStar()), expectedFlyingStarGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.CENTER, WealthStar()), expectedFlyingStarGroup.giveCenterStar().giveStarPosition())
                )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }


    @Test
    fun `giveAdvanceFlyingStars start in 6th month, overflow of 2 years, ending in same month`() {
        val steps = 24
        val month = 6
        val year = 2013

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, IllnessStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, FutureProsperityStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, PeachBlossomStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, MisfortuneStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, VictoryStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, QuarrelsomeStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, WealthStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, BurglaryStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, HeavenStar()), yearlyGroup.giveCenterStar().giveStarPosition())
                )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveAdvancedFlyingStarGroup(steps)

        val yearExpected = 2015

        val expectedYearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(yearExpected)
        val expectedFlyingStarGroup = expectedYearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.NORTH, MisfortuneStar()), expectedFlyingStarGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.NORTHEAST, QuarrelsomeStar()), expectedFlyingStarGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.EAST, BurglaryStar()), expectedFlyingStarGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.SOUTHEAST, WealthStar()), expectedFlyingStarGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.SOUTH, PeachBlossomStar()), expectedFlyingStarGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.SOUTHWEST, HeavenStar()), expectedFlyingStarGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.WEST, IllnessStar()), expectedFlyingStarGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.NORTHWEST, VictoryStar()), expectedFlyingStarGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.CENTER, FutureProsperityStar()), expectedFlyingStarGroup.giveCenterStar().giveStarPosition())
                )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }


    @Test
    fun `giveRewoundFlyingStarGroup start in the fifth month, backflow of three years, ending in the same month`() {
        val steps = 36
        val month = 5
        val year = 2010

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, QuarrelsomeStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, VictoryStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, MisfortuneStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, HeavenStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, IllnessStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, PeachBlossomStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, FutureProsperityStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, WealthStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, BurglaryStar()), yearlyGroup.giveCenterStar().giveStarPosition())
                )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)

        val yearExpected = 2007

        val expectedYearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(yearExpected)
        val expectedFlyingStarGroup = expectedYearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
                setOf(
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.NORTH, QuarrelsomeStar()), expectedFlyingStarGroup.giveNorthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.NORTHEAST, VictoryStar()), expectedFlyingStarGroup.giveNorthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.EAST, MisfortuneStar()), expectedFlyingStarGroup.giveEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.SOUTHEAST, HeavenStar()), expectedFlyingStarGroup.giveSouthEastStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.SOUTH, IllnessStar()), expectedFlyingStarGroup.giveSouthStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.SOUTHWEST, PeachBlossomStar()), expectedFlyingStarGroup.giveSouthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.WEST, FutureProsperityStar()), expectedFlyingStarGroup.giveWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.NORTHWEST, WealthStar()), expectedFlyingStarGroup.giveNorthWestStar().giveStarPosition()),
                    MonthlyFlyingStar(month, yearExpected, StarPosition(CompassDirection.CENTER, BurglaryStar()), expectedFlyingStarGroup.giveCenterStar().giveStarPosition())
                )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }

    @Test
    fun `determine starting month set should return 0 if equal to BASE_YEAR`() {
        val year = BASE_YEAR
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_1, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 3 years greater than BASE_YEAR`() {
        val year = BASE_YEAR + 3
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_1, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 18 years greater than BASE_YEAR`() {
        val year = BASE_YEAR + 18
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_1, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 3 years less than BASE_YEAR`() {
        val year = BASE_YEAR - 3
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_1, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 18 years less than BASE_YEAR`() {
        val year = BASE_YEAR - 18
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_1, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 1 years greater than BASE_YEAR`() {
        val year = BASE_YEAR + 1
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_2, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 19 years greater than BASE_YEAR`() {
        val year = BASE_YEAR + 19
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_2, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 1 years less than BASE_YEAR`() {
        val year = BASE_YEAR - 1
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_2, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 19 years less than BASE_YEAR`() {
        val year = BASE_YEAR - 19
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_2, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 2 years greater than BASE_YEAR`() {
        val year = BASE_YEAR + 2
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_3, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 20 years greater than BASE_YEAR`() {
        val year = BASE_YEAR + 20
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_3, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 2 years less than BASE_YEAR`() {
        val year = BASE_YEAR - 2
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_3, monthSet)
    }

    @Test
    fun `determine starting month set should return 0 if 20 years less than BASE_YEAR`() {
        val year = BASE_YEAR - 20
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_3, monthSet)
    }
    
    @Test
    fun `determine 5th month for 2019`() {
        val year = 2019
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)
        val monthlyFlyingStarGroup1stMonth = monthSet.giveFlyingStarsMonthSet(year)
        val monthlyFlyingStarGroup5thMonth = monthlyFlyingStarGroup1stMonth.giveAdvancedFlyingStarGroup(4)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_1, monthSet)

        assertEquals(WealthStar(), monthlyFlyingStarGroup5thMonth.giveNorthWestStar().giveStarPosition().flyingStar)
        assertEquals(QuarrelsomeStar(), monthlyFlyingStarGroup5thMonth.giveNorthStar().giveStarPosition().flyingStar)
        assertEquals(VictoryStar(), monthlyFlyingStarGroup5thMonth.giveNorthEastStar().giveStarPosition().flyingStar)

        assertEquals(FutureProsperityStar(), monthlyFlyingStarGroup5thMonth.giveWestStar().giveStarPosition().flyingStar)
        assertEquals(BurglaryStar(), monthlyFlyingStarGroup5thMonth.giveCenterStar().giveStarPosition().flyingStar)
        assertEquals(MisfortuneStar(), monthlyFlyingStarGroup5thMonth.giveEastStar().giveStarPosition().flyingStar)

        assertEquals(PeachBlossomStar(), monthlyFlyingStarGroup5thMonth.giveSouthWestStar().giveStarPosition().flyingStar)
        assertEquals(IllnessStar(), monthlyFlyingStarGroup5thMonth.giveSouthStar().giveStarPosition().flyingStar)
        assertEquals(HeavenStar(), monthlyFlyingStarGroup5thMonth.giveSouthEastStar().giveStarPosition().flyingStar)
    }

    @Test
    fun `determine 6th month for 2016`() {
        val year = 2016
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)
        val monthlyFlyingStarGroup1stMonth = monthSet.giveFlyingStarsMonthSet(year)
        val monthlyFlyingStarGroup6thMonth = monthlyFlyingStarGroup1stMonth.giveAdvancedFlyingStarGroup(5)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_1, monthSet)

        assertEquals(BurglaryStar(), monthlyFlyingStarGroup6thMonth.giveNorthWestStar().giveStarPosition().flyingStar)
        assertEquals(IllnessStar(), monthlyFlyingStarGroup6thMonth.giveNorthStar().giveStarPosition().flyingStar)
        assertEquals(FutureProsperityStar(), monthlyFlyingStarGroup6thMonth.giveNorthEastStar().giveStarPosition().flyingStar)

        assertEquals(WealthStar(), monthlyFlyingStarGroup6thMonth.giveWestStar().giveStarPosition().flyingStar)
        assertEquals(HeavenStar(), monthlyFlyingStarGroup6thMonth.giveCenterStar().giveStarPosition().flyingStar)
        assertEquals(PeachBlossomStar(), monthlyFlyingStarGroup6thMonth.giveEastStar().giveStarPosition().flyingStar)

        assertEquals(QuarrelsomeStar(), monthlyFlyingStarGroup6thMonth.giveSouthWestStar().giveStarPosition().flyingStar)
        assertEquals(VictoryStar(), monthlyFlyingStarGroup6thMonth.giveSouthStar().giveStarPosition().flyingStar)
        assertEquals(MisfortuneStar(), monthlyFlyingStarGroup6thMonth.giveSouthEastStar().giveStarPosition().flyingStar)
    }

    @Test
    fun `determine 11th month for 2017`() {
        val year = 2017
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)
        val monthlyFlyingStarGroup1stMonth = monthSet.giveFlyingStarsMonthSet(year)
        val monthlyFlyingStarGroup11thMonth = monthlyFlyingStarGroup1stMonth.giveAdvancedFlyingStarGroup(10)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_2, monthSet)

        assertEquals(WealthStar(), monthlyFlyingStarGroup11thMonth.giveNorthWestStar().giveStarPosition().flyingStar)
        assertEquals(QuarrelsomeStar(), monthlyFlyingStarGroup11thMonth.giveNorthStar().giveStarPosition().flyingStar)
        assertEquals(VictoryStar(), monthlyFlyingStarGroup11thMonth.giveNorthEastStar().giveStarPosition().flyingStar)

        assertEquals(FutureProsperityStar(), monthlyFlyingStarGroup11thMonth.giveWestStar().giveStarPosition().flyingStar)
        assertEquals(BurglaryStar(), monthlyFlyingStarGroup11thMonth.giveCenterStar().giveStarPosition().flyingStar)
        assertEquals(MisfortuneStar(), monthlyFlyingStarGroup11thMonth.giveEastStar().giveStarPosition().flyingStar)

        assertEquals(PeachBlossomStar(), monthlyFlyingStarGroup11thMonth.giveSouthWestStar().giveStarPosition().flyingStar)
        assertEquals(IllnessStar(), monthlyFlyingStarGroup11thMonth.giveSouthStar().giveStarPosition().flyingStar)
        assertEquals(HeavenStar(), monthlyFlyingStarGroup11thMonth.giveSouthEastStar().giveStarPosition().flyingStar)
    }

    @Test
    fun `determine 4th month for 2017`() {
        val year = 2017
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)
        val monthlyFlyingStarGroup1stMonth = monthSet.giveFlyingStarsMonthSet(year)
        val monthlyFlyingStarGroup4thMonth = monthlyFlyingStarGroup1stMonth.giveAdvancedFlyingStarGroup(3)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_2, monthSet)

        assertEquals(HeavenStar(), monthlyFlyingStarGroup4thMonth.giveNorthWestStar().giveStarPosition().flyingStar)
        assertEquals(VictoryStar(), monthlyFlyingStarGroup4thMonth.giveNorthStar().giveStarPosition().flyingStar)
        assertEquals(WealthStar(), monthlyFlyingStarGroup4thMonth.giveNorthEastStar().giveStarPosition().flyingStar)

        assertEquals(BurglaryStar(), monthlyFlyingStarGroup4thMonth.giveWestStar().giveStarPosition().flyingStar)
        assertEquals(MisfortuneStar(), monthlyFlyingStarGroup4thMonth.giveCenterStar().giveStarPosition().flyingStar)
        assertEquals(QuarrelsomeStar(), monthlyFlyingStarGroup4thMonth.giveEastStar().giveStarPosition().flyingStar)

        assertEquals(IllnessStar(), monthlyFlyingStarGroup4thMonth.giveSouthWestStar().giveStarPosition().flyingStar)
        assertEquals(FutureProsperityStar(), monthlyFlyingStarGroup4thMonth.giveSouthStar().giveStarPosition().flyingStar)
        assertEquals(PeachBlossomStar(), monthlyFlyingStarGroup4thMonth.giveSouthEastStar().giveStarPosition().flyingStar)
    }

    @Test
    fun `determine 2nd month for 2018`() {
        val year = 2018
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)
        val monthlyFlyingStarGroup1stMonth = monthSet.giveFlyingStarsMonthSet(year)
        val monthlyFlyingStarGroup2ndMonth = monthlyFlyingStarGroup1stMonth.giveAdvancedFlyingStarGroup(1)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_3, monthSet)

        assertEquals(MisfortuneStar(), monthlyFlyingStarGroup2ndMonth.giveNorthWestStar().giveStarPosition().flyingStar)
        assertEquals(FutureProsperityStar(), monthlyFlyingStarGroup2ndMonth.giveNorthStar().giveStarPosition().flyingStar)
        assertEquals(BurglaryStar(), monthlyFlyingStarGroup2ndMonth.giveNorthEastStar().giveStarPosition().flyingStar)

        assertEquals(HeavenStar(), monthlyFlyingStarGroup2ndMonth.giveWestStar().giveStarPosition().flyingStar)
        assertEquals(PeachBlossomStar(), monthlyFlyingStarGroup2ndMonth.giveCenterStar().giveStarPosition().flyingStar)
        assertEquals(IllnessStar(), monthlyFlyingStarGroup2ndMonth.giveEastStar().giveStarPosition().flyingStar)

        assertEquals(VictoryStar(), monthlyFlyingStarGroup2ndMonth.giveSouthWestStar().giveStarPosition().flyingStar)
        assertEquals(WealthStar(), monthlyFlyingStarGroup2ndMonth.giveSouthStar().giveStarPosition().flyingStar)
        assertEquals(QuarrelsomeStar(), monthlyFlyingStarGroup2ndMonth.giveSouthEastStar().giveStarPosition().flyingStar)
    }

    @Test
    fun `determine 8th month for 2018`() {
        val year = 2018
        val monthSet = MonthlyFlyingStarGroupSet.determineStartingMonthSet(year)
        val monthlyFlyingStarGroup1stMonth = monthSet.giveFlyingStarsMonthSet(year)
        val monthlyFlyingStarGroup8thMonth = monthlyFlyingStarGroup1stMonth.giveAdvancedFlyingStarGroup(7)

        assertEquals(MonthlyFlyingStarGroupSet.MONTH_SET.SET_3, monthSet)

        assertEquals(WealthStar(), monthlyFlyingStarGroup8thMonth.giveNorthWestStar().giveStarPosition().flyingStar)
        assertEquals(QuarrelsomeStar(), monthlyFlyingStarGroup8thMonth.giveNorthStar().giveStarPosition().flyingStar)
        assertEquals(VictoryStar(), monthlyFlyingStarGroup8thMonth.giveNorthEastStar().giveStarPosition().flyingStar)

        assertEquals(FutureProsperityStar(), monthlyFlyingStarGroup8thMonth.giveWestStar().giveStarPosition().flyingStar)
        assertEquals(BurglaryStar(), monthlyFlyingStarGroup8thMonth.giveCenterStar().giveStarPosition().flyingStar)
        assertEquals(MisfortuneStar(), monthlyFlyingStarGroup8thMonth.giveEastStar().giveStarPosition().flyingStar)

        assertEquals(PeachBlossomStar(), monthlyFlyingStarGroup8thMonth.giveSouthWestStar().giveStarPosition().flyingStar)
        assertEquals(IllnessStar(), monthlyFlyingStarGroup8thMonth.giveSouthStar().giveStarPosition().flyingStar)
        assertEquals(HeavenStar(), monthlyFlyingStarGroup8thMonth.giveSouthEastStar().giveStarPosition().flyingStar)
    }

    @Test
    fun `giveRewoundFlyingStarGroup start in first month, backflow of one month`() {
        val steps = 1
        val month = 1 // February
        val year = 2020

        val yearlyGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
        val yearlyGroup = yearlyGroupSet.getFlyingStarsGroup()

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
                setOf(
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, PeachBlossomStar()), yearlyGroup.giveNorthStar().giveStarPosition()),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, IllnessStar()), yearlyGroup.giveNorthEastStar().giveStarPosition()),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, HeavenStar()), yearlyGroup.giveEastStar().giveStarPosition()),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, BurglaryStar()), yearlyGroup.giveSouthEastStar().giveStarPosition()),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, QuarrelsomeStar()), yearlyGroup.giveSouthStar().giveStarPosition()),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, MisfortuneStar()), yearlyGroup.giveSouthWestStar().giveStarPosition()),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, VictoryStar()), yearlyGroup.giveWestStar().giveStarPosition()),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, FutureProsperityStar()), yearlyGroup.giveNorthWestStar().giveStarPosition()),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, WealthStar()), yearlyGroup.giveCenterStar().giveStarPosition())
                )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)

        val monthExpected = 12
        val yearExpected = 2019
        val expectedYearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(yearExpected)
        val expectedFlyingStarGroup = expectedYearlyFlyingStarGroupSet.getFlyingStarsGroup()

        val expected = MonthlyFlyingStarGroup(
                setOf(
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTH, MisfortuneStar()), expectedFlyingStarGroup.giveNorthStar().giveStarPosition()),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHEAST, QuarrelsomeStar()), expectedFlyingStarGroup.giveNorthEastStar().giveStarPosition()),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.EAST, BurglaryStar()), expectedFlyingStarGroup.giveEastStar().giveStarPosition()),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHEAST, WealthStar()), expectedFlyingStarGroup.giveSouthEastStar().giveStarPosition()),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTH, PeachBlossomStar()), expectedFlyingStarGroup.giveSouthStar().giveStarPosition()),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHWEST, HeavenStar()), expectedFlyingStarGroup.giveSouthWestStar().giveStarPosition()),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.WEST, IllnessStar()), expectedFlyingStarGroup.giveWestStar().giveStarPosition()),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHWEST, VictoryStar()), expectedFlyingStarGroup.giveNorthWestStar().giveStarPosition()),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.CENTER, FutureProsperityStar()), expectedFlyingStarGroup.giveCenterStar().giveStarPosition())
                )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }

    @After
    fun tearDown() {
        monthlyFlyingStarGroup = null
    }
}