package com.alexis.chineseastrology.redux.showyearlyflyingstars.processors

import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroupSet
import com.alexis.chineseastrology.redux.showyearlyflyingstars.IShowYearlyFlyingStarsState
import com.alexis.chineseastrology.redux.showyearlyflyingstars.ShowYearlyFlyingStarsAction
import com.alexis.chineseastrology.redux.showyearlyflyingstars.ShowYearlyFlyingStarsNotifyResults
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor
import timber.log.Timber
import java.util.*

class CalculateYearlyFlyingStarsProcessor(
    private val state: IShowYearlyFlyingStarsState,
    private val notifier: INotifier
) : BaseProcessor() {
    override fun process(action: IAction) {
        val actionCasted = action as ShowYearlyFlyingStarsAction.CalculateYearlyFlyingStars
        val year = actionCasted.year ?: Calendar.getInstance().get(Calendar.YEAR)
        val userInitiated = actionCasted.userInitiated

        state.reduce(IShowYearlyFlyingStarsState.MutateKeys.UpdateYear(year))
        if (!userInitiated) {
            notifier.notify(ShowYearlyFlyingStarsNotifyResults.YearUpdated)
        }

        var group: YearlyFlyingStarGroup? = null
        if (year > 0) {
            group = YearlyFlyingStarGroupSet.determineYearSetForYear(year).getFlyingStarsGroup()
        }
        state.reduce(IShowYearlyFlyingStarsState.MutateKeys.UpdateYearlyFlyingStarGroup(group))
        notifier.notify(ShowYearlyFlyingStarsNotifyResults.YearlyFlyingStarGroupUpdated(group))
    }
}
