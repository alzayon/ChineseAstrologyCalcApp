package com.alexis.chineseastrology.lib

import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import com.alexis.chineseastrology.lib.elements.*
import com.alexis.chineseastrology.lib.util.AnimalSignBaseYear
import com.alexis.chineseastrology.lib.util.DateUtil
import com.alexis.chineseastrology.lib.util.Month1
import com.alexis.chineseastrology.lib.util.MonthlyBoundary
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

        var animalSign = findAnimalFromList(year, baseYears)
        animalSign = animalSign.copyWithElement(element)
        if (isBeforeFirstMonth(date)) {
            animalSign = adjustAnimalSignForFirstMonth(animalSign)
        }
        return animalSign
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

    private fun isBeforeFirstMonth(date: Date): Boolean {
        val year = DateUtil.getYearFromDate(date)
        val month1 = Month1()
        val month1DatePair = MonthlyBoundary.convertToDate(year, month1)
        val month1StartDate = month1DatePair.first
        val dateTimestamp = date.time
        val month1DateTimestamp = month1StartDate.time

        return if (dateTimestamp < month1DateTimestamp) true else false
    }

    private fun adjustAnimalSignForFirstMonth(animalSign: IAnimalSign): IAnimalSign {
        var element = animalSign.element
        if (animalSign.gender == Gender.MALE) {
            element = element.getPreviousElement()
        }
        val adjustedAnimal = animalSign.getPreviousAnimalSign()
        return adjustedAnimal.copyWithElement(element)
    }
}