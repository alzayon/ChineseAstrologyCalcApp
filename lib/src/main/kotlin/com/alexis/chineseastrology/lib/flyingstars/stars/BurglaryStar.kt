package com.alexis.chineseastrology.lib.flyingstars.stars

import com.alexis.chineseastrology.lib.general.Charge
import com.alexis.chineseastrology.lib.elements.IElement
import com.alexis.chineseastrology.lib.elements.MetalElement

data class BurglaryStar(public override val element: IElement = MetalElement(),
                        public override val number: Int = 7,
                        public override val charge: Charge = Charge.NEGATIVE): IFlyingStar {

    override fun next(): IFlyingStar {
        return ProsperityStar()
    }

    override fun previous(): IFlyingStar {
        return HeavenStar()
    }
}