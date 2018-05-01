package com.alexis.chineseastrology.lib.flyingstars.stars

import com.alexis.chineseastrology.lib.general.Charge
import com.alexis.chineseastrology.lib.elements.EarthElement
import com.alexis.chineseastrology.lib.elements.IElement

data class ProsperityStar(public override val element: IElement = EarthElement(),
                          public override val number: Int = 8,
                          public override val charge: Charge = Charge.POSITIVE): IFlyingStar {

    override fun next(): IFlyingStar {
        return FutureProsperityStar()
    }

    override fun previous(): IFlyingStar {
        return BurglaryStar()
    }
}