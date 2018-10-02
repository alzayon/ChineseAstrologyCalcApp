package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroupSet
import java.util.*
import javax.inject.Inject

class ShowYearlyFlyingStarsViewModel @Inject constructor() : ViewModel(), IShowYearlyFlyingStarsViewModel {

    override var yearToCalculate =  ObservableInt(0)

    override var yearlyFlyingStarGroup: ObservableField<YearlyFlyingStarGroup?> = ObservableField()

    override fun reset() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        yearToCalculate.set(year)
        calculateYearlyFlyingStarGroup()
    }

    override fun calculateYearlyFlyingStarGroup(): IFlyingStarGroup? {
        val year = yearToCalculate.get()
        var group: YearlyFlyingStarGroup? = null
        if (year > 0) {
            group = YearlyFlyingStarGroupSet.determineYearSetForYear(year).getFlyingStarsGroup()
        }
        yearlyFlyingStarGroup.set(group)
        return group
    }
}