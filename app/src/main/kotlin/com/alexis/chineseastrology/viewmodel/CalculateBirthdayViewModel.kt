package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.ViewModel
import com.alexis.chineseastrology.lib.IBdayCalculator
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import java.util.*
import javax.inject.Inject

class CalculateBirthdayViewModel @Inject constructor(private val bdayCalculator: IBdayCalculator): ViewModel(), ICalculateBirthdayViewModel {
    override fun calculateBirthday(date: Date): IAnimalSign {
        return bdayCalculator.calculate(date)
    }
}