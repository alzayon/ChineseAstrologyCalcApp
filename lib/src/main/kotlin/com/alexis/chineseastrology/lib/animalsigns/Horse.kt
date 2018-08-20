package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.general.Gender
import com.alexis.chineseastrology.lib.elements.FireElement
import com.alexis.chineseastrology.lib.elements.IElement

/**
 * Created by alzayon on 3/26/2018.
 */
data class Horse(public override val element: IElement = FireElement()): IAnimalSign {
    override val gender: Gender
        get() = Gender.MALE
    override val baseElement: IElement
        get() = FireElement()
    override val position: Int
        get() = 7
    override val name: String
        get() = "Horse"

    override fun copyWithElement(element: IElement): IAnimalSign {
        return this.copy(element = element)
    }
}