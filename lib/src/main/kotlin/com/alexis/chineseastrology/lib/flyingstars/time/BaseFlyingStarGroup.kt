package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.general.CompassDirection

abstract class BaseFlyingStarGroup: IFlyingStarGroup {
    protected lateinit var northStar: ITimeFlyingStar
    protected lateinit  var southStar: ITimeFlyingStar
    protected lateinit  var eastStar: ITimeFlyingStar
    protected lateinit  var westStar: ITimeFlyingStar
    protected lateinit  var northEastStar: ITimeFlyingStar
    protected lateinit  var southEastStar: ITimeFlyingStar
    protected lateinit  var southWestStar: ITimeFlyingStar
    protected lateinit  var northWestStar: ITimeFlyingStar
    protected lateinit  var centerStar: ITimeFlyingStar

    fun doBasicStarValidation(unitDescription: String,
                      timeFlyingStars: Set<ITimeFlyingStar>) {
        if (timeFlyingStars.size != 9) {
            throw IllegalArgumentException("Incomplete $unitDescription flying stars supplied to constructor.")
        }

        val distinctStars = timeFlyingStars.distinctBy { it.giveStarPosition().compassDirection }
        if (distinctStars.size != 9) {
            throw IllegalArgumentException("Duplicate $unitDescription flying stars supplied to constructor.")
        }
    }

    override fun giveNorthStar(): ITimeFlyingStar {
        return northStar
    }

    override fun giveNorthEastStar(): ITimeFlyingStar {
        return northEastStar
    }

    override fun giveEastStar(): ITimeFlyingStar {
        return eastStar
    }

    override fun giveSouthEastStar(): ITimeFlyingStar {
        return southEastStar
    }

    override fun giveSouthStar(): ITimeFlyingStar {
        return southStar
    }

    override fun giveSouthWestStar(): ITimeFlyingStar {
        return southWestStar
    }

    override fun giveWestStar(): ITimeFlyingStar {
        return westStar
    }

    override fun giveNorthWestStar(): ITimeFlyingStar {
        return northWestStar
    }

    override fun giveCenterStar(): ITimeFlyingStar {
        return centerStar
    }

    override fun setOfFlyingStars(): Set<ITimeFlyingStar> {
        return setOf(northStar, northEastStar, eastStar, southEastStar,
                southStar, southWestStar, westStar, northWestStar,
                centerStar)
    }

    protected fun setupFlyingStars(timeFlyingStars: List<ITimeFlyingStar>) {
        val distinctStars = timeFlyingStars.distinctBy { it.giveStarPosition().compassDirection }

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

    protected fun findStarForPosition(distinctStars: List<ITimeFlyingStar>,
                                    compassDirection: CompassDirection): ITimeFlyingStar {
        return distinctStars.find { it.giveStarPosition().compassDirection == compassDirection }!!
    }
}