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
    override var monthYearToCalculate =  MutableLiveData<String>()

    override var monthlyFlyingStarGroup = MutableLiveData<MonthlyFlyingStarGroup?>()

    override fun setup() {
        calculateMonthlyFlyingStarGroup()
        monthYearToCalculate.observeForever {
            calculateMonthlyFlyingStarGroup()
        }
    }

    override fun reset() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        monthYearToCalculate.postValue(year.toString())
    }

    override fun moveMonthToCalculate(direction: Int) {
        val year = monthYearToCalculate.value
        year?.let {
            var yearInt = 0
            if (it.trim().isEmpty()) {
                reset()
            } else {
                yearInt = year.toInt()
            }

            if (direction == 1) {
                val year = yearInt.inc()
                monthYearToCalculate.postValue(year.toString())
            } else {
                val year = yearInt.dec()
                monthYearToCalculate.postValue(year.toString())
            }
        }
    }

    private fun calculateMonthlyFlyingStarGroup(): IFlyingStarGroup? {
        val (month, year) = splitStringToMonthYear()
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

    private fun splitStringToMonthYear(): Pair<Int, Int> {
        val value = monthYearToCalculate.value
        return Pair(1, 2018)
    }
}