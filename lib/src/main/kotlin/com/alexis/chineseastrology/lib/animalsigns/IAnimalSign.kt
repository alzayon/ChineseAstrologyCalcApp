package com.alexis.chineseastrology.lib.animalsigns

import com.alexis.chineseastrology.lib.general.Gender
import com.alexis.chineseastrology.lib.elements.IElement

/**
 * Created by alzayon on 3/26/2018.
 */
interface IAnimalSign {
    val gender: Gender
    val baseElement: IElement
    val element: IElement
    val position: Int

    //TODO
    //Use string resource files
    val name: String

    fun copyWithElement(element: IElement): IAnimalSign

    fun getPreviousAnimalSign(): IAnimalSign {
        var targetPosition = this.position - 1
        if (this.position == 1) {
            targetPosition == 12
        }
        val list = AnimalSignBaseYear.getAllBaseYears()
        val found = list.filter {
            it.animalSign.position == targetPosition
        }.first()

        return found.animalSign
    }
}