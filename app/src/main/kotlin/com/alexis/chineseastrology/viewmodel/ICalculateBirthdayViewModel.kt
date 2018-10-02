package com.alexis.chineseastrology.viewmodel

import android.databinding.ObservableField
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import java.util.*

interface ICalculateBirthdayViewModel {
    var date: ObservableField<Date>
    var animalSign: ObservableField<IAnimalSign>
    fun calculateBirthday(): IAnimalSign
    fun reset()
}