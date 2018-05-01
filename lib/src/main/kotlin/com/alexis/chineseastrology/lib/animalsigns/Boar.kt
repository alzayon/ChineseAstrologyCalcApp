package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.general.Gender
import com.alexis.chineseastrology.lib.elements.IElement
import com.alexis.chineseastrology.lib.elements.WaterElement

/**
 * Created by alzayon on 3/27/2018.
 */
data class Boar(public override val element: IElement = WaterElement()): IAnimalSign {
    override val gender: Gender
        get() = Gender.FEMALE
    override val baseElement: IElement
        get() = WaterElement()
    override val position: Int
        get() = 12

    override fun copyWithElement(element: IElement): IAnimalSign {
        return this.copy(element = element)
    }
}