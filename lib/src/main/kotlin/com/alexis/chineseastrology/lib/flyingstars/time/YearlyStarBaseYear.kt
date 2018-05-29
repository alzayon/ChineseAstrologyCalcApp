package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.StarPosition
import com.alexis.chineseastrology.lib.flyingstars.stars.*
import com.alexis.chineseastrology.lib.general.CompassDirection



class YearlyStarBaseYear {
    companion object {
        private var yearlyFlyingStarGroup: YearlyFlyingStarGroup? = null

        init {
            if (yearlyFlyingStarGroup != null) {
                val northStar = YearlyFlyingStar(2013, StarPosition(CompassDirection.NORTH, VictoryStar()))
                val northEastStar = YearlyFlyingStar(2013, StarPosition(CompassDirection.NORTHEAST, WealthStar()))
                val eastStar = YearlyFlyingStar(2013, StarPosition(CompassDirection.EAST, QuarrelsomeStar()))
                val southEastStar = YearlyFlyingStar(2013, StarPosition(CompassDirection.SOUTHEAST, PeachBlossomStar()))
                val southStar = YearlyFlyingStar(2013, StarPosition(CompassDirection.SOUTH, FutureProsperityStar()))
                val southWestStar = YearlyFlyingStar(2013, StarPosition(CompassDirection.SOUTHWEST, IllnessStar()))
                val westStar = YearlyFlyingStar(2013, StarPosition(CompassDirection.WEST, BurglaryStar()))
                val northWestStar = YearlyFlyingStar(2013, StarPosition(CompassDirection.NORTHWEST, HeavenStar()))
                val centerStar = YearlyFlyingStar(2013, StarPosition(CompassDirection.CENTER, MisfortuneStar()))

                val yearlyFlyingStars = setOf(northStar, northEastStar, eastStar, southEastStar, southStar,
                        southWestStar, westStar, northWestStar, centerStar)

                yearlyFlyingStarGroup = YearlyFlyingStarGroup(yearlyFlyingStars)
            }
        }

        fun getYearlyFlyingStarsGroupForBaseYear(): YearlyFlyingStarGroup {
            return yearlyFlyingStarGroup!!
        }
    }
}