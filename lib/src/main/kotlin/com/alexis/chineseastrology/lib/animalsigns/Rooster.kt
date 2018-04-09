package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.Gender
import com.alexis.chineseastrology.lib.elements.IElement
import com.alexis.chineseastrology.lib.elements.MetalElement

/**
 * Created by alzayon on 3/27/2018.
 */
data class Rooster(public override val element: IElement = MetalElement()): IAnimalSign {
    override val gender: Gender
        get() = Gender.FEMALE
    override val baseElement: IElement
        get() = MetalElement()
    override val position: Int
        get() = 10

    override fun copyWithElement(element: IElement): IAnimalSign {
        return this.copy(element = element)
    }
}