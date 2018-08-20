package com.alexis.chineseastrology.presenter

import com.alexis.chineseastrology.lib.IBdayCalculator
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import java.util.*

internal class CalculateBirthdayPresenter(val bdayCalculator: IBdayCalculator): ICalculateBirthdayPresenter {
    override fun calculateBirthday(date: Date): IAnimalSign {
        return bdayCalculator.calculate(date)
    }
}