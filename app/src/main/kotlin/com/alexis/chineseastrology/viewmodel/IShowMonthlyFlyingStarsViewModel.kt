package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup

interface IShowMonthlyFlyingStarsViewModel {
    var monthYearToCalculate: MutableLiveData<String>
    var monthlyFlyingStarGroup: MutableLiveData<MonthlyFlyingStarGroup?>
    fun setup()
    fun reset()
    fun moveMonthToCalculate(direction: Int)
}