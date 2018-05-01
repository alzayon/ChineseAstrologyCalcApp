package com.alexis.chineseastrology.lib.flyingstars.stars

import com.alexis.chineseastrology.lib.general.Charge
import com.alexis.chineseastrology.lib.elements.IElement
import com.alexis.chineseastrology.lib.elements.WoodElement

data class PeachBlossomStar(public override val element: IElement = WoodElement(),
                            public override val number: Int = 4,
                            public override val charge: Charge = Charge.POSITIVE): IFlyingStar