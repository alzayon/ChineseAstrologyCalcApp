package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.general.Gender
import com.alexis.chineseastrology.lib.elements.IElement
import com.alexis.chineseastrology.lib.elements.WoodElement

/**
 * Created by alzayon on 3/26/2018.
 */
data class Rabbit(public override val element: IElement = WoodElement()): IAnimalSign {
    override val gender: Gender
        get() = Gender.FEMALE
    override val baseElement: IElement
        get() = WoodElement()
    override val position: Int
        get() = 4

    override fun copyWithElement(element: IElement): IAnimalSign {
        return this.copy(element = element)
    }
}