package com.alexis.chineseastrology.lib.flyingstars.stars

import com.alexis.chineseastrology.lib.general.Charge
import com.alexis.chineseastrology.lib.elements.IElement

interface IFlyingStar {
    val element: IElement
    val number: Int
    val charge: Charge

    companion object {
        fun getAllFlyingStars(): List<IFlyingStar> {
            return listOf(VictoryStar(),
                    IllnessStar(),
                    QuarrelsomeStar(),
                    PeachBlossomStar(),
                    MisfortuneStar(),
                    HeavenStar(),
                    BurglaryStar(),
                    WealthStar(),
                    FutureProsperityStar())
        }

        fun advanceByPosition(steps: Int, flyingStar: IFlyingStar): IFlyingStar {
            if (steps < 1) {
                throw IllegalArgumentException("Invalid steps specified.")
            }
            var newFlyingStar: IFlyingStar? = flyingStar
            for (i in 1..steps) {
                //IMPORTANT
                //Flying stars move forward by moving backwards in number
                //and vice versa...
                newFlyingStar = newFlyingStar?.previous()
            }
            return newFlyingStar!!
        }

        fun rewindByPosition(steps: Int, flyingStar: IFlyingStar): IFlyingStar {
            if (steps < 1) {
                throw IllegalArgumentException("Invalid steps specified.")
            }
            var stepsToUse = - Math.abs(steps)
            var newFlyingStar: IFlyingStar? = flyingStar
            for (i in -1 downTo stepsToUse) {
                //IMPORTANT
                //Flying stars move forward by moving backwards in number
                //and vice versa...
                newFlyingStar = newFlyingStar?.next()
            }
            return newFlyingStar!!
        }
    }

    fun next(): IFlyingStar
    fun previous(): IFlyingStar
}