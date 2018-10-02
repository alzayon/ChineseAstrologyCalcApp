package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.StarPosition
import com.alexis.chineseastrology.lib.flyingstars.stars.*
import com.alexis.chineseastrology.lib.general.CompassDirection
import java.lang.RuntimeException

class YearlyFlyingStarGroupSet {

    enum class YearSet(val number: Int) {
        YEARSET1(1),
        YEARSET2(2),
        YEARSET3(3),
        YEARSET4(4),
        YEARSET5(5),
        YEARSET6(6),
        YEARSET7(7),
        YEARSET8(8),
        YEARSET9(9);

        fun getFlyingStarsGroup(): YearlyFlyingStarGroup {
            return when(this.number) {
                1 -> giveYearlyFlyingStarMonthSet1()
                2 -> giveYearlyFlyingStarMonthSet2()
                3 -> giveYearlyFlyingStarMonthSet3()
                4 -> giveYearlyFlyingStarMonthSet4()
                5 -> giveYearlyFlyingStarMonthSet5()
                6 -> giveYearlyFlyingStarMonthSet6()
                7 -> giveYearlyFlyingStarMonthSet7()
                8 -> giveYearlyFlyingStarMonthSet8()
                else -> giveYearlyFlyingStarMonthSet9()
            }
        }
    }

    companion object {

        fun determineYearSetForYear(year: Int): YearSet {
            if (year == 0) {
                throw IllegalArgumentException("Year must be greater than zero.")
            }
            val startYear = 2012
            var numberToUse = 0
            var remainder = 0
            if (year < startYear) {
                remainder = startYear % year
            } else {
                remainder = year % startYear
            }

            if (remainder > 9) {
                remainder = remainder % 9
            }

            if (remainder == 0) {
                numberToUse = 9
            } else {
                numberToUse = remainder
                if (year < startYear) {
                    numberToUse = 9 - numberToUse
                }
            }
            return findYearSetByNum(numberToUse)
        }

        fun findYearSetByNum(number: Int): YearSet {
            if (number > 9 || number < 1) {
                throw RuntimeException(IllegalArgumentException("Specify only numbers 1 to 9"))
            }
            return YearSet.values().filter {
                it.number == number
            }.first()
        }

        private fun giveYearlyFlyingStarMonthSet1(): YearlyFlyingStarGroup {
            val northStar = YearlyFlyingStar( 2013, StarPosition(CompassDirection.NORTH, VictoryStar()))
            val northEastStar = YearlyFlyingStar( 2013, StarPosition(CompassDirection.NORTHEAST, WealthStar()))
            val northWestStar = YearlyFlyingStar( 2013, StarPosition(CompassDirection.NORTHWEST, HeavenStar()))

            val southStar = YearlyFlyingStar( 2013, StarPosition(CompassDirection.SOUTH, FutureProsperityStar()))
            val southEastStar = YearlyFlyingStar( 2013, StarPosition(CompassDirection.SOUTHEAST, PeachBlossomStar()))
            val southWestStar = YearlyFlyingStar( 2013, StarPosition(CompassDirection.SOUTHWEST, IllnessStar()))

            val eastStar = YearlyFlyingStar( 2013, StarPosition(CompassDirection.EAST, QuarrelsomeStar()))
            val westStar = YearlyFlyingStar( 2013, StarPosition(CompassDirection.WEST, BurglaryStar()))
            val centerStar = YearlyFlyingStar( 2013, StarPosition(CompassDirection.CENTER, MisfortuneStar()))

            val set: Set<YearlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return YearlyFlyingStarGroup(set)
        }

        private fun giveYearlyFlyingStarMonthSet2(): YearlyFlyingStarGroup {
            val northStar = YearlyFlyingStar( 2014, StarPosition(CompassDirection.NORTH, FutureProsperityStar()))
            val northEastStar = YearlyFlyingStar( 2014, StarPosition(CompassDirection.NORTHEAST, BurglaryStar()))
            val northWestStar = YearlyFlyingStar( 2014, StarPosition(CompassDirection.NORTHWEST, MisfortuneStar()))

            val southStar = YearlyFlyingStar( 2014, StarPosition(CompassDirection.SOUTH, WealthStar()))
            val southEastStar = YearlyFlyingStar( 2014, StarPosition(CompassDirection.SOUTHEAST, QuarrelsomeStar()))
            val southWestStar = YearlyFlyingStar( 2014, StarPosition(CompassDirection.SOUTHWEST, VictoryStar()))

            val eastStar = YearlyFlyingStar( 2014, StarPosition(CompassDirection.EAST, IllnessStar()))
            val westStar = YearlyFlyingStar( 2014, StarPosition(CompassDirection.WEST, HeavenStar()))
            val centerStar = YearlyFlyingStar( 2014, StarPosition(CompassDirection.CENTER, PeachBlossomStar()))

            val set: Set<YearlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return YearlyFlyingStarGroup(set)
        }

        private fun giveYearlyFlyingStarMonthSet3(): YearlyFlyingStarGroup {
            val northStar = YearlyFlyingStar( 2015, StarPosition(CompassDirection.NORTH, WealthStar()))
            val northEastStar = YearlyFlyingStar( 2015, StarPosition(CompassDirection.NORTHEAST, HeavenStar()))
            val northWestStar = YearlyFlyingStar( 2015, StarPosition(CompassDirection.NORTHWEST, PeachBlossomStar()))

            val southStar = YearlyFlyingStar( 2015, StarPosition(CompassDirection.SOUTH, BurglaryStar()))
            val southEastStar = YearlyFlyingStar( 2015, StarPosition(CompassDirection.SOUTHEAST, IllnessStar()))
            val southWestStar = YearlyFlyingStar( 2015, StarPosition(CompassDirection.SOUTHWEST, FutureProsperityStar()))

            val eastStar = YearlyFlyingStar( 2015, StarPosition(CompassDirection.EAST, VictoryStar()))
            val westStar = YearlyFlyingStar( 2015, StarPosition(CompassDirection.WEST, MisfortuneStar()))
            val centerStar = YearlyFlyingStar( 2015, StarPosition(CompassDirection.CENTER, QuarrelsomeStar()))

            val set: Set<YearlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return YearlyFlyingStarGroup(set)
        }

        private fun giveYearlyFlyingStarMonthSet4(): YearlyFlyingStarGroup {
            val northStar = YearlyFlyingStar( 2016, StarPosition(CompassDirection.NORTH, BurglaryStar()))
            val northEastStar = YearlyFlyingStar( 2016, StarPosition(CompassDirection.NORTHEAST, MisfortuneStar()))
            val northWestStar = YearlyFlyingStar( 2016, StarPosition(CompassDirection.NORTHWEST, QuarrelsomeStar()))

            val southStar = YearlyFlyingStar( 2016, StarPosition(CompassDirection.SOUTH, HeavenStar()))
            val southEastStar = YearlyFlyingStar( 2016, StarPosition(CompassDirection.SOUTHEAST, VictoryStar()))
            val southWestStar = YearlyFlyingStar( 2016, StarPosition(CompassDirection.SOUTHWEST, WealthStar()))

            val eastStar = YearlyFlyingStar( 2016, StarPosition(CompassDirection.EAST, FutureProsperityStar()))
            val westStar = YearlyFlyingStar( 2016, StarPosition(CompassDirection.WEST, PeachBlossomStar()))
            val centerStar = YearlyFlyingStar( 2016, StarPosition(CompassDirection.CENTER, IllnessStar()))

            val set: Set<YearlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return YearlyFlyingStarGroup(set)
        }

        private fun giveYearlyFlyingStarMonthSet5(): YearlyFlyingStarGroup {
            val northStar = YearlyFlyingStar( 2017, StarPosition(CompassDirection.NORTH, HeavenStar()))
            val northEastStar = YearlyFlyingStar( 2017, StarPosition(CompassDirection.NORTHEAST, PeachBlossomStar()))
            val northWestStar = YearlyFlyingStar( 2017, StarPosition(CompassDirection.NORTHWEST, IllnessStar()))

            val southStar = YearlyFlyingStar( 2017, StarPosition(CompassDirection.SOUTH, MisfortuneStar()))
            val southEastStar = YearlyFlyingStar( 2017, StarPosition(CompassDirection.SOUTHEAST, FutureProsperityStar()))
            val southWestStar = YearlyFlyingStar( 2017, StarPosition(CompassDirection.SOUTHWEST, BurglaryStar()))

            val eastStar = YearlyFlyingStar( 2017, StarPosition(CompassDirection.EAST, WealthStar()))
            val westStar = YearlyFlyingStar( 2017, StarPosition(CompassDirection.WEST, QuarrelsomeStar()))
            val centerStar = YearlyFlyingStar( 2017, StarPosition(CompassDirection.CENTER, VictoryStar()))

            val set: Set<YearlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return YearlyFlyingStarGroup(set)
        }

        private fun giveYearlyFlyingStarMonthSet6(): YearlyFlyingStarGroup {
            val northStar = YearlyFlyingStar( 2018, StarPosition(CompassDirection.NORTH, MisfortuneStar()))
            val northEastStar = YearlyFlyingStar( 2018, StarPosition(CompassDirection.NORTHEAST, QuarrelsomeStar()))
            val northWestStar = YearlyFlyingStar( 2018, StarPosition(CompassDirection.NORTHWEST, VictoryStar()))

            val southStar = YearlyFlyingStar( 2018, StarPosition(CompassDirection.SOUTH, PeachBlossomStar()))
            val southEastStar = YearlyFlyingStar( 2018, StarPosition(CompassDirection.SOUTHEAST, WealthStar()))
            val southWestStar = YearlyFlyingStar( 2018, StarPosition(CompassDirection.SOUTHWEST, HeavenStar()))

            val eastStar = YearlyFlyingStar( 2018, StarPosition(CompassDirection.EAST, BurglaryStar()))
            val westStar = YearlyFlyingStar( 2018, StarPosition(CompassDirection.WEST, IllnessStar()))
            val centerStar = YearlyFlyingStar( 2018, StarPosition(CompassDirection.CENTER, FutureProsperityStar()))

            val set: Set<YearlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return YearlyFlyingStarGroup(set)
        }

        private fun giveYearlyFlyingStarMonthSet7(): YearlyFlyingStarGroup {
            val northStar = YearlyFlyingStar( 2019, StarPosition(CompassDirection.NORTH, PeachBlossomStar()))
            val northEastStar = YearlyFlyingStar( 2019, StarPosition(CompassDirection.NORTHEAST, IllnessStar()))
            val northWestStar = YearlyFlyingStar( 2019, StarPosition(CompassDirection.NORTHWEST, FutureProsperityStar()))

            val southStar = YearlyFlyingStar( 2019, StarPosition(CompassDirection.SOUTH, QuarrelsomeStar()))
            val southEastStar = YearlyFlyingStar( 2019, StarPosition(CompassDirection.SOUTHEAST, BurglaryStar()))
            val southWestStar = YearlyFlyingStar( 2019, StarPosition(CompassDirection.SOUTHWEST, MisfortuneStar()))

            val eastStar = YearlyFlyingStar( 2019, StarPosition(CompassDirection.EAST, HeavenStar()))
            val westStar = YearlyFlyingStar( 2019, StarPosition(CompassDirection.WEST, VictoryStar()))
            val centerStar = YearlyFlyingStar( 2019, StarPosition(CompassDirection.CENTER, WealthStar()))

            val set: Set<YearlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return YearlyFlyingStarGroup(set)
        }

        private fun giveYearlyFlyingStarMonthSet8(): YearlyFlyingStarGroup {
            val northStar = YearlyFlyingStar( 2020, StarPosition(CompassDirection.NORTH, QuarrelsomeStar()))
            val northEastStar = YearlyFlyingStar( 2020, StarPosition(CompassDirection.NORTHEAST, VictoryStar()))
            val northWestStar = YearlyFlyingStar( 2020, StarPosition(CompassDirection.NORTHWEST, WealthStar()))

            val southStar = YearlyFlyingStar( 2020, StarPosition(CompassDirection.SOUTH, IllnessStar()))
            val southEastStar = YearlyFlyingStar( 2020, StarPosition(CompassDirection.SOUTHEAST, HeavenStar()))
            val southWestStar = YearlyFlyingStar( 2020, StarPosition(CompassDirection.SOUTHWEST, PeachBlossomStar()))

            val eastStar = YearlyFlyingStar( 2020, StarPosition(CompassDirection.EAST, MisfortuneStar()))
            val westStar = YearlyFlyingStar( 2020, StarPosition(CompassDirection.WEST, FutureProsperityStar()))
            val centerStar = YearlyFlyingStar( 2020, StarPosition(CompassDirection.CENTER, BurglaryStar()))

            val set: Set<YearlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return YearlyFlyingStarGroup(set)
        }

        private fun giveYearlyFlyingStarMonthSet9(): YearlyFlyingStarGroup {
            val northStar = YearlyFlyingStar( 2021, StarPosition(CompassDirection.NORTH, IllnessStar()))
            val northEastStar = YearlyFlyingStar( 2021, StarPosition(CompassDirection.NORTHEAST, FutureProsperityStar()))
            val northWestStar = YearlyFlyingStar( 2021, StarPosition(CompassDirection.NORTHWEST, BurglaryStar()))

            val southStar = YearlyFlyingStar( 2021, StarPosition(CompassDirection.SOUTH, VictoryStar()))
            val southEastStar = YearlyFlyingStar( 2021, StarPosition(CompassDirection.SOUTHEAST, MisfortuneStar()))
            val southWestStar = YearlyFlyingStar( 2021, StarPosition(CompassDirection.SOUTHWEST, QuarrelsomeStar()))

            val eastStar = YearlyFlyingStar( 2021, StarPosition(CompassDirection.EAST, PeachBlossomStar()))
            val westStar = YearlyFlyingStar( 2021, StarPosition(CompassDirection.WEST, WealthStar()))
            val centerStar = YearlyFlyingStar( 2021, StarPosition(CompassDirection.CENTER, HeavenStar()))

            val set: Set<YearlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return YearlyFlyingStarGroup(set)
        }
    }
}