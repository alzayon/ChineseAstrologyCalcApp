package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.general.Gender
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
    override val position: Int
        get() = 9

    override fun copyWithElement(element: IElement): IAnimalSign {
        return this.copy(element = element)
    }
}