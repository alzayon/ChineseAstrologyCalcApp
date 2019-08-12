package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen

import com.alexis.redux.notifier.BaseNotifyResult
import java.util.*

sealed class NotifyResults : BaseNotifyResult() {
    class YearlyFlyingStarGroupUpdated : NotifyResults()
    class YearUpdated : NotifyResults()
    class BoundariesUpdated(val start: Date, val end: Date) : NotifyResults()
}