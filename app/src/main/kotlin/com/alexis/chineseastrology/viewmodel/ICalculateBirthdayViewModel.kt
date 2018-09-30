package com.alexis.chineseastrology.viewmodel

import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import java.util.*

interface ICalculateBirthdayViewModel {
    fun calculateBirthday(date: Date): IAnimalSign
}