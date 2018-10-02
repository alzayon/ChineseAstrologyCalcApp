package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableInt
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroupSet
import java.util.*
import javax.inject.Inject

class ShowYearlyFlyingStarsViewModel @Inject constructor() : ViewModel(), IShowYearlyFlyingStarsViewModel {

    override var yearToCalculate =  ObservableInt(0)

    override fun reset() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        yearToCalculate.set(year)
    }

    override fun calculateYearlyFlyingStarGroup(year: Int): YearlyFlyingStarGroup {
        return YearlyFlyingStarGroupSet.determineYearSetForYear(year).getFlyingStarsGroup()
    }
}