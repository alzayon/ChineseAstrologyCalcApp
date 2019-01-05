package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroupSet
import java.util.*
import javax.inject.Inject

class ShowYearlyFlyingStarsViewModel @Inject constructor() : ViewModel(), IShowYearlyFlyingStarsViewModel {
    override var yearToCalculate =  MutableLiveData<Int>()

    override var yearlyFlyingStarGroup = MutableLiveData<YearlyFlyingStarGroup?>()

    override fun setup() {
        calculateYearlyFlyingStarGroup()
        yearToCalculate.observeForever {
            calculateYearlyFlyingStarGroup()
        }
    }

    override fun reset() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        yearToCalculate.postValue(year)
    }

    override fun moveYearToCalculate(direction: Int) {
        val year = yearToCalculate.value
        year?.let {
            if (direction == 1) {
                val yearComputed = it.inc()
                yearToCalculate.postValue(yearComputed)
            } else {
                val yearComputed = it.dec()
                yearToCalculate.postValue(yearComputed)
            }
        }
    }

    private fun calculateYearlyFlyingStarGroup(): IFlyingStarGroup? {
        val year = yearToCalculate.value
        var group: YearlyFlyingStarGroup? = null
        year?.let {
            if (it > 0) {
                group = YearlyFlyingStarGroupSet.determineYearSetForYear(it).getFlyingStarsGroup()
            }
            yearlyFlyingStarGroup.postValue(group)
        }
        return group
    }
}