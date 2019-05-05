package com.alexis.chineseastrology.redux.showyearlyflyingstars

import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.redux.notifier.BaseNotifyResult

sealed class ShowYearlyFlyingStarsNotifyResults : BaseNotifyResult() {
    class YearlyFlyingStarGroupUpdated(val yearlyFlyingStarsGroup: YearlyFlyingStarGroup?) : ShowYearlyFlyingStarsNotifyResults()
    object YearUpdated : ShowYearlyFlyingStarsNotifyResults()
}