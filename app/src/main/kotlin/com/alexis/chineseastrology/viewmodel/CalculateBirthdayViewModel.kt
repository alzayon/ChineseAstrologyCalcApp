package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.alexis.chineseastrology.lib.IBdayCalculator
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class CalculateBirthdayViewModel @Inject constructor(private val bdayCalculator: IBdayCalculator) :
        ViewModel(), ICalculateBirthdayViewModel {

    override var date: MutableLiveData<Date?> = MutableLiveData()

    override var animalSign: MutableLiveData<IAnimalSign> = MutableLiveData()

    override fun calculateBirthday(): IAnimalSign {
        val result = bdayCalculator.calculate(date.value!!)
        Timber.d("Calcuate BaseNotifyResult %s", result)
        animalSign.postValue(result)
        return result
    }

    override fun reset() {
        date.postValue(Date())
        animalSign.postValue(null)
    }

    override fun setDate(newDate: Date?) {
        date.postValue(newDate)
    }
}