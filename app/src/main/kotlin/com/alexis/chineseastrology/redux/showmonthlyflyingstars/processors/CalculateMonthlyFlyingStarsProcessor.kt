package com.alexis.chineseastrology.redux.showmonthlyflyingstars.processors

import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroupSet
import com.alexis.chineseastrology.redux.showmonthlyflyingstars.IShowMonthlyFlyingStarsState
import com.alexis.chineseastrology.redux.showmonthlyflyingstars.ShowMonthlyFlyingStarsAction
import com.alexis.chineseastrology.redux.showmonthlyflyingstars.ShowMonthlyFlyingStarsNotifyResults
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor
import java.util.*

class CalculateMonthlyFlyingStarsProcessor(
    private val state: IShowMonthlyFlyingStarsState,
    private val notifier: INotifier
) : BaseProcessor() {
    override fun process(action: IAction) {
        val actionCasted = action as ShowMonthlyFlyingStarsAction.CalculateMonthlyFlyingStars
        val year = actionCasted.year ?: Calendar.getInstance().get(Calendar.YEAR)
        val userInitiated = actionCasted.userInitiated

        //state.reduce(IShowMonthlyFlyingStarsState.MutateKeys.UpdateMonthYear(month, year))
        if (!userInitiated) {
            //notifier.notify(ShowMonthlyFlyingStarsNotifyResults.YearUpdated)
        }

        var group: MonthlyFlyingStarGroup? = null
        if (year > 0) {
            //group = MonthlyFlyingStarGroupSet.determineYearSetForYear(year).getFlyingStarsGroup()
        }
        //state.reduce(IShowYearlyFlyingStarsState.MutateKeys.UpdateYearlyFlyingStarGroup(group))
        //notifier.notify(ShowYearlyFlyingStarsNotifyResults.YearlyFlyingStarGroupUpdated(group))
    }
}