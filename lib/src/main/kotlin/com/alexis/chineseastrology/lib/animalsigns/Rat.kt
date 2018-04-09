package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.Gender
import com.alexis.chineseastrology.lib.elements.IElement
import com.alexis.chineseastrology.lib.elements.WaterElement

/**
 * Created by alzayon on 3/26/2018.
 */
data class Rat(public override val element: IElement = WaterElement()): IAnimalSign {
    override val gender: Gender
        get() = Gender.MALE
    override val baseElement: IElement
        get() = WaterElement()
    override val position: Int
        get() = 1

    override fun copyWithElement(element: IElement): IAnimalSign {
        return this.copy(element = element)
    }
}