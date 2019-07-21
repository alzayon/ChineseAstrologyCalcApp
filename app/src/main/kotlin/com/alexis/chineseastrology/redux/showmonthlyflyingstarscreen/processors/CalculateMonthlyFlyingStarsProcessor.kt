package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.processors

import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroupSet
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
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
        notifier.notify(ShowMonthlyFlyingStarsNotifyResults.MonthYearUpdated())

        var group: MonthlyFlyingStarGroup? = null
        if (isValidParams(year, month)) {
            group = getMonthlyFlyingStarsAdaptMonth(month, year)

            val next = group.giveAdvancedFlyingStarGroup(1) as MonthlyFlyingStarGroup
            val previous = group.giveRewoundFlyingStarGroup(1) as MonthlyFlyingStarGroup

            state.reduce(IShowMonthlyFlyingStarsState.MutateKeys.UpdateMonthlyFlyingStarGroup(group))
            state.reduce(IShowMonthlyFlyingStarsState.MutateKeys.UpdateNextAndPreviousMonthlyFlyingStarGroup(next, previous))

        } else {
            // TODO
            // Show an error
        }

        notifier.notify(ShowMonthlyFlyingStarsNotifyResults.MonthlyFlyingStarGroupUpdated())
    }

    private fun isValidParams(year: Int, month: Int): Boolean {
        return (year > 0) && ((month > -1) && (month < 12))
    }

    private fun getMonthlyFlyingStarsAdaptMonth(month: Int, year: Int): MonthlyFlyingStarGroup {
        // NOTE
        // Monthly flyings stars index starts at 1
        // Monthly flying stars 1st month is February, 12th is January of next year
        // However, the Java calendar index starts at 0
        // and Java calendar 1st month is January

        // Also, if the month is January, use the yearly flying star for the previous year
        // Flying star month index starts at 1, while Java calendar starts at 0

        // Considering all the points above
        // Make the necessary adjustments
        var yearToUse = year
        var monthToUse = month
        if (monthToUse == 0) {
            // Use the previous year and use the month 12
            yearToUse = year - 1
            monthToUse = 12
        }
        return MonthlyFlyingStarGroupSet.getMonthlyFlyingStars(monthToUse, yearToUse)
    }
}