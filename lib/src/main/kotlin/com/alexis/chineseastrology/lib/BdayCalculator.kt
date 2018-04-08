package com.alexis.chineseastrology.lib

import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import com.alexis.chineseastrology.lib.elements.*
import com.alexis.chineseastrology.lib.util.AnimalSignBaseYear
import com.alexis.chineseastrology.lib.util.DateUtil
import java.util.*


/**
 * Created by alzayon on 3/30/2018.
 */
class BdayCalculator: IBdayCalculator {
    override fun calculate(date: Date): IAnimalSign {
        val year = DateUtil.getYearFromDate(date)
        val element = determineElement(date)
        val gender = Gender.getYearGender(date)
        var baseYears = AnimalSignBaseYear.getMaleBaseYears()
        if (gender == Gender.FEMALE) {
            baseYears = AnimalSignBaseYear.getFemaleBaseYears()
        }
        val animalSign = findAnimalFromList(year, baseYears)
        return animalSign.copyWithElement(element)
    }

    override fun determineElement(date: Date): IElement {
        val year = DateUtil.getYearFromDate(date)
        val yearAsString = year.toString()
        val lastNumber = (yearAsString.substring(3)).toInt()

        //TODO
        //Consider first month

        when (lastNumber) {
            0, 1 -> return MetalElement()
            2, 3 -> return WaterElement()
            4, 5 -> return WoodElement()
            6, 7 -> return FireElement()
            else -> return EarthElement()
        }
    }

    private fun findAnimalFromList(year: Int, list: List<AnimalSignBaseYear>): IAnimalSign {
        //TODO
        //Consider first month
        return list.filter {
            var r = it.year % year
            if (it.year < year) {
                r = year % it.year
            }
            val r2 = r % 12

            ((r == 0) || (r2 == 0))
        }.map {
            it.animalSign
        }.first()

    }
}