package com.alexis.chineseastrology.lib.flyingstars.stars

import com.alexis.chineseastrology.lib.general.Charge
import com.alexis.chineseastrology.lib.elements.IElement
import com.alexis.chineseastrology.lib.elements.WoodElement

data class QuarrelsomeStar(public override val element: IElement = WoodElement(),
                           public override val number: Int = 3,
                           public override val charge: Charge = Charge.NEGATIVE): IFlyingStar {

    override fun next(): IFlyingStar {
        return PeachBlossomStar()
    }

    override fun previous(): IFlyingStar {
        return IllnessStar()
    }
}