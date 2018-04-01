package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.Gender
import com.alexis.chineseastrology.lib.elements.IElement

/**
 * Created by alzayon on 3/26/2018.
 */
interface IAnimalSign {
    val gender: Gender
    val baseElement: IElement
    val element: IElement

    fun copyWithElement(element: IElement): IAnimalSign
}