package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import java.util.*

interface IShowMonthlyFlyingStarsViewModel {
    var date: MutableLiveData<Date?>
    var monthlyFlyingStarGroup: MutableLiveData<MonthlyFlyingStarGroup?>
    fun setup()
    fun reset()
    fun moveMonthToCalculate(direction: Int)
}