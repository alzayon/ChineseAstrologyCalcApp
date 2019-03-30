package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import java.util.*

interface IShowYearlyFlyingStarsViewModel {
    var yearToCalculate: MutableLiveData<Int>
    var yearlyFlyingStarGroup: MutableLiveData<YearlyFlyingStarGroup?>
    fun setup()
    fun reset()
    fun moveYearToCalculate(direction: Int)

    //TODO
    //Determine why Databinding causes a StackOverflow exception if the return type is void/Unit
    //fun calculateYearlyFlyingStarGroup(): IFlyingStarGroup?
}