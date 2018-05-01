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
                    ProsperityStar(),
                    FutureProsperityStar())
        }

        fun advanceByPosition(steps: Int, flyingStar: IFlyingStar): IFlyingStar {
            if (steps < 1) {
                throw IllegalArgumentException("Invalid steps specified.")
            }
            var newFlyingStar: IFlyingStar? = null
            for (i in 1..steps) {
                newFlyingStar = flyingStar.next()
            }
            return newFlyingStar!!
        }
    }

    fun next(): IFlyingStar
    fun previous(): IFlyingStar
}