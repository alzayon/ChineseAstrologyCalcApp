package com.alexis.chineseastrology.lib.flyingstars.stars

import com.alexis.chineseastrology.lib.general.Charge
import com.alexis.chineseastrology.lib.elements.IElement
import com.alexis.chineseastrology.lib.elements.WaterElement

data class VictoryStar(public override val element: IElement = WaterElement(),
                       public override val number: Int = 1,
                       public override val charge: Charge = Charge.POSITIVE): IFlyingStar {

    override fun next(): IFlyingStar {
        return IllnessStar()
    }

    override fun previous(): IFlyingStar {
        return FutureProsperityStar()
    }
}