package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen

import com.alexis.redux.notifier.BaseNotifyResult

sealed class NotifyResults : BaseNotifyResult() {
    class MonthlyFlyingStarGroupUpdated : NotifyResults()
    class MonthYearUpdated : NotifyResults()
}