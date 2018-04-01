package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.Gender
import com.alexis.chineseastrology.lib.elements.IElement
import com.alexis.chineseastrology.lib.elements.MetalElement

/**
 * Created by alzayon on 3/27/2018.
 */
data class Monkey(public override val element: IElement = MetalElement()): IAnimalSign {
    override val gender: Gender
        get() = Gender.MALE
    override val baseElement: IElement
        get() = MetalElement()

    override fun copyWithElement(element: IElement): IAnimalSign {
        return this.copy(element = element)
    }
}