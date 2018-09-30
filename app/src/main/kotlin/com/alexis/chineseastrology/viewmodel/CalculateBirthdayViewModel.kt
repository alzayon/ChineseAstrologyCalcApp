package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.ViewModel

import android.databinding.ObservableField
import com.alexis.chineseastrology.lib.IBdayCalculator
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import java.util.*
import javax.inject.Inject

class CalculateBirthdayViewModel @Inject constructor(private val bdayCalculator: IBdayCalculator): ViewModel(), ICalculateBirthdayViewModel {
    override var date: ObservableField<Date> = ObservableField(Date())
    override var animalSign: ObservableField<IAnimalSign> = ObservableField()

    override fun calculateBirthday(): IAnimalSign {
        return bdayCalculator.calculate(date.get())
    }
}