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
}