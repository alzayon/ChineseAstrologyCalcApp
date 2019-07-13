package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.processors

import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.IShowMonthlyFlyingStarsState
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsAction
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsNotifyResults
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor
import java.util.*

class CalculateMonthlyFlyingStarsProcessor(
    private val state: IShowMonthlyFlyingStarsState,
    private val notifier: INotifier
) : BaseProcessor<Unit>() {

    override fun process(action: IAction)  {
        val actionCasted = action as ShowMonthlyFlyingStarsAction.CalculateMonthlyFlyingStars
        val calendar = Calendar.getInstance()
        val year = actionCasted.year ?: calendar.get(Calendar.YEAR)
        val month: Int = actionCasted.month ?: calendar.get(Calendar.MONTH)
        val userInitiated = actionCasted.userInitiated

        state.reduce(IShowMonthlyFlyingStarsState.MutateKeys.UpdateMonthYear(month, year))
        if (!userInitiated) {
            notifier.notify(ShowMonthlyFlyingStarsNotifyResults.MonthYearUpdated())
        }

        var group: MonthlyFlyingStarGroup? = null
        if (year > 0) {
            //group = MonthlyFlyingStarGroupSet.determineYearSetForYear(year).getFlyingStarsGroup()
        }
        //state.reduce(IShowYearlyFlyingStarsState.MutateKeys.UpdateYearlyFlyingStarGroup(group))
        //notifier.notify(ShowYearlyFlyingStarsNotifyResults.YearlyFlyingStarGroupUpdated(group))
    }
}