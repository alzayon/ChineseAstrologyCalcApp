package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.ViewModel
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroupSet
import javax.inject.Inject

class ShowYearlyFlyingStarsViewModel @Inject constructor() : ViewModel(), IShowYearlyFlyingStarsViewModel {
    override fun calculateYearlyFlyingStarGroup(year: Int): YearlyFlyingStarGroup {
        return YearlyFlyingStarGroupSet.determineYearSetForYear(year).getFlyingStarsGroup()
    }
}