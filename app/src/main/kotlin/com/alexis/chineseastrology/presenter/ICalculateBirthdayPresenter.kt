package com.alexis.chineseastrology.presenter

import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import java.util.*

interface ICalculateBirthdayPresenter {
    fun calculateBirthday(date: Date): IAnimalSign
}