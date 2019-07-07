package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen

import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.redux.notifier.BaseNotifyResult

sealed class ShowMonthlyFlyingStarsNotifyResults : BaseNotifyResult() {
    class MonthlyFlyingStarGroupUpdated(val monthlyFlyingStarsGroup: MonthlyFlyingStarGroup?) : ShowMonthlyFlyingStarsNotifyResults()
    object MonthUpdated : ShowMonthlyFlyingStarsNotifyResults()
}