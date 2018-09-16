package com.alexis.chineseastrology.lib.flyingstars.time

interface IFlyingStarGroup {
    fun setOfFlyingStars(): Set<ITimeFlyingStar>

    fun giveNorthStar(): ITimeFlyingStar
    fun giveNorthEastStar(): ITimeFlyingStar
    fun giveEastStar(): ITimeFlyingStar
    fun giveSouthEastStar(): ITimeFlyingStar
    fun giveSouthStar(): ITimeFlyingStar
    fun giveSouthWestStar(): ITimeFlyingStar
    fun giveWestStar(): ITimeFlyingStar
    fun giveNorthWestStar(): ITimeFlyingStar
    fun giveCenterStar(): ITimeFlyingStar

    fun getStarByOrder(orderNumber: Int): ITimeFlyingStar {
        return when (orderNumber) {
            0 -> giveNorthStar()
            1 -> giveNorthEastStar()
            2 -> giveEastStar()
            3 -> giveSouthEastStar()
            4 -> giveSouthStar()
            5 -> giveSouthWestStar()
            6 -> giveWestStar()
            7 -> giveNorthWestStar()
            else -> giveCenterStar()
        }
    }
}