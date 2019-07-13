package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen

import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.redux.notifier.BaseNotifyResult

sealed class ShowYearlyFlyingStarsNotifyResults : BaseNotifyResult() {
    class YearlyFlyingStarGroupUpdated : ShowYearlyFlyingStarsNotifyResults()
    class YearUpdated : ShowYearlyFlyingStarsNotifyResults()
}