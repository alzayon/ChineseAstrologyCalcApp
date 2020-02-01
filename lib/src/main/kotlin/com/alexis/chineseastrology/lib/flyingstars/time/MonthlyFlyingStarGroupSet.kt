package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.StarPosition
import com.alexis.chineseastrology.lib.flyingstars.stars.*
import com.alexis.chineseastrology.lib.general.CompassDirection

// TODO
// Maybe make it a sealed class
// We only have three sets
class MonthlyFlyingStarGroupSet {

    // The 1st month of each year falls under one of three sets
    // If you get the first month, it is easy to calculate subsequent months for the rest of the year

    companion object {
        const val BASE_YEAR = 2013
        const val SET_COUNT = 3

        fun determineStartingMonthSet(year: Int): MONTH_SET {
            var remainder = 0
            var difference = 0
            if (year == BASE_YEAR)
                return MONTH_SET.getByIndex(remainder)
            if (year > BASE_YEAR) {
                difference = year - BASE_YEAR
            } else {
                difference = BASE_YEAR - year
            }
            remainder = difference % SET_COUNT
            return MONTH_SET.getByIndex(remainder)
        }

        // TODO
        // When the month is 12th, meaning January
        // Use the flying stars from the previous year
        // Unit test
        fun getMonthlyFlyingStars(month: Int, year: Int): MonthlyFlyingStarGroup {

            // NOTE
            // 1st month  = Feb
            // 12th month = Jan
            // If month is 12, use the month set for the previous year
            val monthSet = determineStartingMonthSet(year)
            var group = monthSet.giveFlyingStarsMonthSet(year)
            if (month == 1) { // month 1 is February
                return group
            } else {
                val steps = (month - 1)
                group = monthSet.giveFlyingStarsMonthSet(year).giveAdvancedFlyingStarGroup(steps) as MonthlyFlyingStarGroup
                return group
            }
        }

        fun giveMonthlyFlyingStarGroupFirstMonthSet1(year: Int = 2013): MonthlyFlyingStarGroup {

            val yearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
            val flyingStarGroup = yearlyFlyingStarGroupSet.getFlyingStarsGroup()

            val northStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.NORTH, BurglaryStar()), flyingStarGroup.giveNorthStar().giveStarPosition())
            val northEastStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.NORTHEAST, MisfortuneStar()), flyingStarGroup.giveNorthEastStar().giveStarPosition())
            val northWestStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.NORTHWEST, QuarrelsomeStar()), flyingStarGroup.giveNorthWestStar().giveStarPosition())

            val southStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.SOUTH, HeavenStar()), flyingStarGroup.giveSouthStar().giveStarPosition())
            val southEastStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.SOUTHEAST, VictoryStar()), flyingStarGroup.giveSouthEastStar().giveStarPosition())
            val southWestStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.SOUTHWEST, WealthStar()), flyingStarGroup.giveSouthWestStar().giveStarPosition())

            val eastStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.EAST, FutureProsperityStar()), flyingStarGroup.giveEastStar().giveStarPosition())
            val westStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.WEST, PeachBlossomStar()), flyingStarGroup.giveWestStar().giveStarPosition())
            val centerStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.CENTER, IllnessStar()), flyingStarGroup.giveCenterStar().giveStarPosition())

            val list: Set<MonthlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return MonthlyFlyingStarGroup(list)
        }

        fun giveMonthlyFlyingStarGroupFirstMonthSet2(year: Int = 2014): MonthlyFlyingStarGroup {

            val yearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
            val flyingStarGroup = yearlyFlyingStarGroupSet.getFlyingStarsGroup()

            val northStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.NORTH, PeachBlossomStar()), flyingStarGroup.giveNorthStar().giveStarPosition())
            val northEastStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.NORTHEAST, IllnessStar()), flyingStarGroup.giveNorthEastStar().giveStarPosition())
            val northWestStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.NORTHWEST, FutureProsperityStar()), flyingStarGroup.giveNorthWestStar().giveStarPosition())

            val southStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.SOUTH, QuarrelsomeStar()), flyingStarGroup.giveSouthStar().giveStarPosition())
            val southEastStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.SOUTHEAST, BurglaryStar()), flyingStarGroup.giveSouthEastStar().giveStarPosition())
            val southWestStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.SOUTHWEST, MisfortuneStar()), flyingStarGroup.giveSouthWestStar().giveStarPosition())

            val eastStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.EAST, HeavenStar()), flyingStarGroup.giveEastStar().giveStarPosition())
            val westStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.WEST, VictoryStar()), flyingStarGroup.giveWestStar().giveStarPosition())
            val centerStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.CENTER, WealthStar()), flyingStarGroup.giveCenterStar().giveStarPosition())

            val list: Set<MonthlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return MonthlyFlyingStarGroup(list)
        }

        fun giveMonthlyFlyingStarGroupFirstMonthSet3(year: Int = 2015): MonthlyFlyingStarGroup {

            val yearlyFlyingStarGroupSet = YearlyFlyingStarGroupSet.determineYearSet(year)
            val flyingStarGroup = yearlyFlyingStarGroupSet.getFlyingStarsGroup()

            val northStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.NORTH, VictoryStar()), flyingStarGroup.giveNorthStar().giveStarPosition())
            val northEastStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.NORTHEAST, WealthStar()), flyingStarGroup.giveNorthEastStar().giveStarPosition())
            val northWestStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.NORTHWEST, HeavenStar()), flyingStarGroup.giveNorthWestStar().giveStarPosition())

            val southStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.SOUTH, FutureProsperityStar()), flyingStarGroup.giveSouthStar().giveStarPosition())
            val southEastStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.SOUTHEAST, PeachBlossomStar()), flyingStarGroup.giveSouthEastStar().giveStarPosition())
            val southWestStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.SOUTHWEST, IllnessStar()), flyingStarGroup.giveSouthWestStar().giveStarPosition())

            val eastStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.EAST, QuarrelsomeStar()), flyingStarGroup.giveEastStar().giveStarPosition())
            val westStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.WEST, BurglaryStar()), flyingStarGroup.giveWestStar().giveStarPosition())
            val centerStar = MonthlyFlyingStar(1, year, StarPosition(CompassDirection.CENTER, MisfortuneStar()), flyingStarGroup.giveCenterStar().giveStarPosition())

            val list: Set<MonthlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return MonthlyFlyingStarGroup(list)
        }
    }

    enum class MONTH_SET(val index: Int) {
        SET_1(0), SET_2(1), SET_3(2);

        companion object {
            fun getByIndex(index: Int): MONTH_SET {
                return when (index) {
                    0    -> SET_1
                    1    -> SET_2
                    else -> SET_3
                }
            }
        }

        fun giveFlyingStarsMonthSet(year: Int): MonthlyFlyingStarGroup {
            return when (this) {
                SET_1 -> giveMonthlyFlyingStarGroupFirstMonthSet1(year)
                SET_2 -> giveMonthlyFlyingStarGroupFirstMonthSet2(year)
                else -> giveMonthlyFlyingStarGroupFirstMonthSet3(year)
            }
        }
    }
}