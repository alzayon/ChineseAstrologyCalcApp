package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.processors

import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroupSet
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.IShowYearlyFlyingStarsState
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.ShowYearlyFlyingStarsAction
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.ShowYearlyFlyingStarsNotifyResults
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor
import java.util.*

class CalculateYearlyFlyingStarsProcessor(
    private val state: IShowYearlyFlyingStarsState,
    private val notifier: INotifier
) : BaseProcessor<Unit>() {
    override fun process(action: IAction) {
        val actionCasted = action as ShowYearlyFlyingStarsAction.CalculateYearlyFlyingStars
        val year = actionCasted.year ?: Calendar.getInstance().get(Calendar.YEAR)
        val userInitiated = actionCasted.userInitiated

        state.reduce(IShowYearlyFlyingStarsState.MutateKeys.UpdateYear(year))
        if (!userInitiated) {
            notifier.notify(ShowYearlyFlyingStarsNotifyResults.YearUpdated())
        }

        var group: YearlyFlyingStarGroup? = null
        if (year > 0) {
            group = YearlyFlyingStarGroupSet.determineYearSet(year).getFlyingStarsGroup()

            val previous = group.giveRewoundFlyingStarGroup(1) as YearlyFlyingStarGroup
            val next = group.giveAdvancedFlyingStarGroup(1) as YearlyFlyingStarGroup

            state.reduce(IShowYearlyFlyingStarsState.MutateKeys.UpdateYearlyFlyingStarGroup(group))
            state.reduce(IShowYearlyFlyingStarsState.MutateKeys.UpdatePreviousAndNextYearlyFlyingStarGroup(previous, next))
        }

        notifier.notify(ShowYearlyFlyingStarsNotifyResults.YearlyFlyingStarGroupUpdated())
    }
}
