package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.ViewModel

import android.databinding.ObservableField
import com.alexis.chineseastrology.lib.IBdayCalculator
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class CalculateBirthdayViewModel @Inject constructor(private val bdayCalculator: IBdayCalculator): ViewModel(), ICalculateBirthdayViewModel {
    override var date: ObservableField<Date> = ObservableField(Date())
    override var animalSign: ObservableField<IAnimalSign> = ObservableField()

    override fun calculateBirthday(): IAnimalSign {
        val result = bdayCalculator.calculate(date.get()!!)
        Timber.d("Calcuate Result %s", result)
        animalSign.set(result)
        return result
    }

    override fun reset() {
        date.set(Date())
        animalSign.set(null)
    }


}