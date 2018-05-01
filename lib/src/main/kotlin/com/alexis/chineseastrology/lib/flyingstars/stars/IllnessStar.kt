package com.alexis.chineseastrology.lib.flyingstars.stars

import com.alexis.chineseastrology.lib.general.Charge
import com.alexis.chineseastrology.lib.elements.EarthElement
import com.alexis.chineseastrology.lib.elements.IElement

data class IllnessStar(public override val element: IElement = EarthElement(),
                       public override val number: Int = 2,
                       public override val charge: Charge = Charge.NEGATIVE): IFlyingStar {

    override fun next(): IFlyingStar {
        return QuarrelsomeStar()
    }

    override fun previous(): IFlyingStar {
        return VictoryStar()
    }
}