package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.StarPosition
import com.alexis.chineseastrology.lib.flyingstars.stars.*
import com.alexis.chineseastrology.lib.general.CompassDirection

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

        fun giveMonthlyFlyingStarGroupFirstMonthSet1(): MonthlyFlyingStarGroup {
            val northStar = MonthlyFlyingStar(1, 2013, StarPosition(CompassDirection.NORTH, BurglaryStar()))
            val northEastStar = MonthlyFlyingStar(1, 2013, StarPosition(CompassDirection.NORTHEAST, MisfortuneStar()))
            val northWestStar = MonthlyFlyingStar(1, 2013, StarPosition(CompassDirection.NORTHWEST, QuarrelsomeStar()))

            val southStar = MonthlyFlyingStar(1, 2013, StarPosition(CompassDirection.SOUTH, HeavenStar()))
            val southEastStar = MonthlyFlyingStar(1, 2013, StarPosition(CompassDirection.SOUTHEAST, VictoryStar()))
            val southWestStar = MonthlyFlyingStar(1, 2013, StarPosition(CompassDirection.SOUTHWEST, WealthStar()))

            val eastStar = MonthlyFlyingStar(1, 2013, StarPosition(CompassDirection.EAST, FutureProsperityStar()))
            val westStar = MonthlyFlyingStar(1, 2013, StarPosition(CompassDirection.WEST, PeachBlossomStar()))
            val centerStar = MonthlyFlyingStar(1, 2013, StarPosition(CompassDirection.CENTER, IllnessStar()))

            val list: Set<MonthlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return MonthlyFlyingStarGroup(list)
        }

        fun giveMonthlyFlyingStarGroupFirstMonthSet2(): MonthlyFlyingStarGroup {
            val northStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.NORTH, PeachBlossomStar()))
            val northEastStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.NORTHEAST, IllnessStar()))
            val northWestStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.NORTHWEST, FutureProsperityStar()))

            val southStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.SOUTH, QuarrelsomeStar()))
            val southEastStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.SOUTHEAST, BurglaryStar()))
            val southWestStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.SOUTHWEST, MisfortuneStar()))

            val eastStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.EAST, HeavenStar()))
            val westStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.WEST, VictoryStar()))
            val centerStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.CENTER, WealthStar()))

            val list: Set<MonthlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return MonthlyFlyingStarGroup(list)
        }

        fun giveMonthlyFlyingStarGroupFirstMonthSet3(): MonthlyFlyingStarGroup {
            val northStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.NORTH, VictoryStar()))
            val northEastStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.NORTHEAST, WealthStar()))
            val northWestStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.NORTHWEST, HeavenStar()))

            val southStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.SOUTH, FutureProsperityStar()))
            val southEastStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.SOUTHEAST, PeachBlossomStar()))
            val southWestStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.SOUTHWEST, IllnessStar()))

            val eastStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.EAST, QuarrelsomeStar()))
            val westStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.WEST, BurglaryStar()))
            val centerStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.CENTER, MisfortuneStar()))

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

        fun giveFlyingStarsMonthSet(): MonthlyFlyingStarGroup {
            return when (this) {
                SET_1 -> giveMonthlyFlyingStarGroupFirstMonthSet1()
                SET_2 -> giveMonthlyFlyingStarGroupFirstMonthSet2()
                else -> giveMonthlyFlyingStarGroupFirstMonthSet3()
            }
        }
    }
}