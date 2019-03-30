package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import java.util.*

interface ICalculateBirthdayViewModel {
    var date: MutableLiveData<Date?>
    var animalSign: MutableLiveData<IAnimalSign>

    //TODO
    //Determine why Databinding causes a StackOverflow exception if the return type is void/Unit
    fun calculateBirthday(): IAnimalSign
    fun reset()
    fun setDate(newDate: Date?)
}