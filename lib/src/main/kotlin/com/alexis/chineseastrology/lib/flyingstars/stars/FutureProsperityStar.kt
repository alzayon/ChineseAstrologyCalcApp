package com.alexis.chineseastrology.lib.flyingstars.stars

import com.alexis.chineseastrology.lib.general.Charge
import com.alexis.chineseastrology.lib.elements.FireElement
import com.alexis.chineseastrology.lib.elements.IElement

data class FutureProsperityStar(public override val element: IElement = FireElement(),
                                public override val number: Int = 9,
                                public override val charge: Charge = Charge.POSITIVE): IFlyingStar {

    override fun next(): IFlyingStar {
        return VictoryStar()
    }

    override fun previous(): IFlyingStar {
        return WealthStar()
    }
}