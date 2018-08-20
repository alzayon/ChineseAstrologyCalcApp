package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.general.Gender
import com.alexis.chineseastrology.lib.elements.IElement
import com.alexis.chineseastrology.lib.elements.WaterElement

/**
 * Created by alzayon on 3/26/2018.
 */
data class Ox(public override val element: IElement = WaterElement()): IAnimalSign {
    override val gender: Gender
        get() = Gender.FEMALE
    override val baseElement: IElement
        get() = WaterElement()
    override val position: Int
        get() = 2
    override val name: String
        get() = "Ox"

    override fun copyWithElement(element: IElement): IAnimalSign {
        return this.copy(element = element)
    }
}