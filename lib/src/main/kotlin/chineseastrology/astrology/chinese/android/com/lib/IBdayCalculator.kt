package com.alexis.chineseastrology.lib

import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import com.alexis.chineseastrology.lib.elements.IElement
import java.util.*

/**
 * Created by alzayon on 3/26/2018.
 */
public interface IBdayCalculator {
    fun calculate(date: Date): IAnimalSign
    fun determineElement(date: Date): IElement
}