package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroupSet
import java.util.*
import javax.inject.Inject

class ShowMonthlyFlyingStarsViewModel @Inject constructor() : ViewModel(), IShowMonthlyFlyingStarsViewModel {
    override var date = MutableLiveData<Date?>()
    override var monthlyFlyingStarGroup = MutableLiveData<MonthlyFlyingStarGroup?>()

    override fun setup() {
        calculateMonthlyFlyingStarGroup()
        date.observeForever {
            calculateMonthlyFlyingStarGroup()
        }
    }

    override fun reset() {
        date.postValue(Date())
    }

    override fun moveMonthToCalculate(direction: Int) {
        date.value?.let {
            if (direction == 1) {
//                val year = yearInt.inc()
//                monthYearToCalculate.postValue(year.toString())
            } else {
//                val year = yearInt.dec()
//                monthYearToCalculate.postValue(year.toString())
            }
        }
    }

    private fun calculateMonthlyFlyingStarGroup(): IFlyingStarGroup? {
        var group: YearlyFlyingStarGroup? = null
//        year?.let {
//            var yearInt = 0
//            if (it.trim().isEmpty()) {
//                reset()
//            } else {
//                yearInt = year.toInt()
//            }
//
//            if (yearInt > 0) {
//                group = YearlyFlyingStarGroupSet.determineYearSetForYear(yearInt).getFlyingStarsGroup()
//            }
//            yearlyFlyingStarGroup.postValue(group)
//        }
        return group
    }
}