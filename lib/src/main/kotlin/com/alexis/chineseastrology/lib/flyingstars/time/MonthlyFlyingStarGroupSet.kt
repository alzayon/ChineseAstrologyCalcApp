package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.StarPosition
import com.alexis.chineseastrology.lib.flyingstars.stars.*
import com.alexis.chineseastrology.lib.general.CompassDirection

class MonthlyFlyingStarGroupSet {

    companion object {
        fun giveMonthlyFlyingStarFirstMonthSet1(): MonthlyFlyingStarGroup {
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

        fun giveMonthlyFlyingStarFirstMonthSet2(): MonthlyFlyingStarGroup {
            val northStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.NORTH, PeachBlossomStar()))
            val northEastStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.NORTHEAST, IllnessStar()))
            val northWestStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.NORTHWEST, FutureProsperityStar()))

            val southStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.SOUTH, QuarrelsomeStar()))
            val southEastStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.SOUTHEAST, BurglaryStar()))
            val southWestStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.SOUTHWEST, MisfortuneStar()))

            val eastStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.EAST, WealthStar()))
            val westStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.WEST, HeavenStar()))
            val centerStar = MonthlyFlyingStar(1, 2014, StarPosition(CompassDirection.CENTER, VictoryStar()))

            val list: Set<MonthlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return MonthlyFlyingStarGroup(list)
        }

        fun giveMonthlyFlyingStarFirstMonthSet3(): MonthlyFlyingStarGroup {
            val northStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.NORTH, VictoryStar()))
            val northEastStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.NORTHEAST, WealthStar()))
            val northWestStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.NORTHWEST, HeavenStar()))

            val southStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.SOUTH, FutureProsperityStar()))
            val southEastStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.SOUTHEAST, PeachBlossomStar()))
            val southWestStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.SOUTHWEST, IllnessStar()))

            val eastStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.EAST, MisfortuneStar()))
            val westStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.WEST, QuarrelsomeStar()))
            val centerStar = MonthlyFlyingStar(1, 2015, StarPosition(CompassDirection.CENTER, BurglaryStar()))

            val list: Set<MonthlyFlyingStar> = setOf(northStar, northEastStar, northWestStar,
                    southStar, southEastStar, southWestStar, eastStar, westStar, centerStar)
            return MonthlyFlyingStarGroup(list)
        }
    }
}