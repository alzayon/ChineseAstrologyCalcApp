package com.alexis.chineseastrology.viewmodel

import android.databinding.ObservableInt
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup

interface IShowYearlyFlyingStarsViewModel {
    var yearToCalculate: ObservableInt
    fun reset()
    fun calculateYearlyFlyingStarGroup(year: Int): YearlyFlyingStarGroup
}