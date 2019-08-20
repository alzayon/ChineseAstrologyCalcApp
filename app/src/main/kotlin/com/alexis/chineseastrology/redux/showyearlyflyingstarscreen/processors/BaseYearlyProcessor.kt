package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.processors

import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.NotifyResults
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor
import java.util.*

abstract class BaseYearlyProcessor<T, W : IAction> : BaseProcessor<T, W>() {
    protected fun notifyChangedBoundaries(
        notifier: INotifier,
        yearlyFlyingStarGroup: YearlyFlyingStarGroup
    ) {
        yearlyFlyingStarGroup?.let {
            val year = yearlyFlyingStarGroup.year
            val start = it.giveStartBoundary(year)
            val end = it.giveEndBoundary(year)
            val calendar1 = Calendar.getInstance()
            calendar1.set(start.year, start.month - 1, start.day)
            val startDate = calendar1.time

            val calendar2 = Calendar.getInstance()
            calendar2.set(end.year, end.month - 1, end.day)
            val endDate = calendar2.time

            notifier.notify(NotifyResults.BoundariesUpdated(startDate, endDate))
        }
    }
}