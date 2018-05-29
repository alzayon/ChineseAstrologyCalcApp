package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.StarPosition
import com.alexis.chineseastrology.lib.flyingstars.stars.*
import com.alexis.chineseastrology.lib.general.CompassDirection
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MonthlyFlyingGroupTest {

    private var monthlyFlyingStarGroup:MonthlyFlyingStarGroup? = null

    @Before
    fun setup() {
        monthlyFlyingStarGroup = MonthlyFlyingStarGroupSet.giveMonthlyFlyingStarFirstMonthSet1()
    }

    @Test
    fun `giveAdvancedFlyingStarGroup() happy path same year`() {
        val steps = 3
        val month = 4
        val year = 2013
        val monthlyFlyingStarGroupAdvanced =
                monthlyFlyingStarGroup?.giveAdvancedFlyingStarGroup(steps)

        val expected = MonthlyFlyingStarGroup(
            setOf(
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, PeachBlossomStar())),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, IllnessStar())),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, HeavenStar())),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, BurglaryStar())),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, QuarrelsomeStar())),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, MisfortuneStar())),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, VictoryStar())),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, FutureProsperityStar())),
                MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, WealthStar()))
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

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
                setOf(
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, QuarrelsomeStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, VictoryStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, MisfortuneStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, HeavenStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, IllnessStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, PeachBlossomStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, FutureProsperityStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, WealthStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, BurglaryStar()))
                )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)

        val monthExpected = 3
        val expected = MonthlyFlyingStarGroup(
                setOf(
                        MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.NORTH, MisfortuneStar())),
                        MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.NORTHEAST, QuarrelsomeStar())),
                        MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.EAST, BurglaryStar())),
                        MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.SOUTHEAST, WealthStar())),
                        MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.SOUTH, PeachBlossomStar())),
                        MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.SOUTHWEST, HeavenStar())),
                        MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.WEST, IllnessStar())),
                        MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.NORTHWEST, VictoryStar())),
                        MonthlyFlyingStar(monthExpected, year, StarPosition(CompassDirection.CENTER, FutureProsperityStar()))
                )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }

    @Test
    fun `giveAdvancedFlyingStarGroup() overflow of one year`() {
        val steps = 17
        val month = 6
        val year = 2014

        val monthlyFlyingStarGroupAdvanced =
                monthlyFlyingStarGroup?.giveAdvancedFlyingStarGroup(steps)

        val expected = MonthlyFlyingStarGroup(
                setOf(
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, WealthStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, HeavenStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, VictoryStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, IllnessStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, BurglaryStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, FutureProsperityStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, MisfortuneStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, PeachBlossomStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, QuarrelsomeStar()))
                )
        )
        assertNotNull(monthlyFlyingStarGroupAdvanced)
        assertEquals(expected, monthlyFlyingStarGroupAdvanced)
    }

    @Test
    fun `giveRewoundFlyingStarGroup backflow of one year`() {
        val steps = 3
        val month = 10
        val year = 2012

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)


        val expected = MonthlyFlyingStarGroup(
                setOf(
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, VictoryStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, WealthStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, QuarrelsomeStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, PeachBlossomStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, FutureProsperityStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, IllnessStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, BurglaryStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, HeavenStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, MisfortuneStar()))
                )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }

    @Test
    fun `giveRewoundFlyingStarGroup backflow of one year, starting in the mid year`() {
        val steps = 10
        val month = 5
        val year = 2013

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
                setOf(
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, QuarrelsomeStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, VictoryStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, MisfortuneStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, HeavenStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, IllnessStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, PeachBlossomStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, FutureProsperityStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, WealthStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, BurglaryStar()))
                )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)

        val monthExpected = 7
        val yearExpected = 2012

        val expected = MonthlyFlyingStarGroup(
                setOf(
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTH, PeachBlossomStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHEAST, IllnessStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.EAST, HeavenStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHEAST, BurglaryStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTH, QuarrelsomeStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHWEST, MisfortuneStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.WEST, VictoryStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHWEST, FutureProsperityStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.CENTER, WealthStar()))
                )
        )
        assertNotNull(monthlyFlyingStarGroupRewound)
        assertEquals(expected, monthlyFlyingStarGroupRewound)
    }

    @Test
    fun `giveAdvancedFlyingStarGroup() overflow of two years`() {
        val steps = 28
        val month = 5
        val year = 2015

        val monthlyFlyingStarGroupAdvanced =
                monthlyFlyingStarGroup?.giveAdvancedFlyingStarGroup(steps)

        val expected = MonthlyFlyingStarGroup(
                setOf(
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, HeavenStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, PeachBlossomStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, WealthStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, FutureProsperityStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, MisfortuneStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, BurglaryStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, QuarrelsomeStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, IllnessStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, VictoryStar()))
                )
        )
        assertNotNull(monthlyFlyingStarGroupAdvanced)
        assertEquals(expected, monthlyFlyingStarGroupAdvanced)
    }

    @Test
    fun `giveRewoundFlyingStarGroup backflow of 3 years`() {
        val steps = 30
        val month = 5
        val year = 2013

        monthlyFlyingStarGroup = MonthlyFlyingStarGroup(
                setOf(
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTH, QuarrelsomeStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHEAST, VictoryStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.EAST, MisfortuneStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHEAST, HeavenStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTH, IllnessStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.SOUTHWEST, PeachBlossomStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.WEST, FutureProsperityStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.NORTHWEST, WealthStar())),
                        MonthlyFlyingStar(month, year, StarPosition(CompassDirection.CENTER, BurglaryStar()))
                )
        )

        val monthlyFlyingStarGroupRewound =
                monthlyFlyingStarGroup?.giveRewoundFlyingStarGroup(steps)


        val monthExpected = 11
        val yearExpected = 2010

        val expected = MonthlyFlyingStarGroup(
                setOf(
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTH, HeavenStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHEAST, PeachBlossomStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.EAST, WealthStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHEAST, FutureProsperityStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTH, MisfortuneStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.SOUTHWEST, BurglaryStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.WEST, QuarrelsomeStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.NORTHWEST, IllnessStar())),
                        MonthlyFlyingStar(monthExpected, yearExpected, StarPosition(CompassDirection.CENTER, VictoryStar()))
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