package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.Gender
import com.alexis.chineseastrology.lib.elements.FireElement
import com.alexis.chineseastrology.lib.elements.IElement

/**
 * Created by alzayon on 3/27/2018.
 */
data class Sheep(public override val element: IElement = FireElement()): IAnimalSign {
    override val gender: Gender
        get() = Gender.FEMALE
    override val baseElement: IElement
        get() = FireElement()

    override fun copyWithElement(element: IElement): IAnimalSign {
        return this.copy(element = element)
    }
}