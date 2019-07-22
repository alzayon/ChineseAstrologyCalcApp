package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.processors

import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.IShowYearlyFlyingStarsState
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.ShowYearlyFlyingStarsAction
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.ShowYearlyFlyingStarsNotifyResults
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor
import com.alexis.redux.store.IDispatcher

class MoveYearToCalculateProcessor(
        private val state: IShowYearlyFlyingStarsState,
        private val dispatcher: IDispatcher,
        private val notifier: INotifier
) : BaseProcessor<Unit>() {
    override fun process(action: IAction) {
        val actionCasted = action as ShowYearlyFlyingStarsAction.MoveYearToCalculate
        val direction = actionCasted.movement
        var yearComputed = 0

        val group = state.yearlyFlyingStarGroup
        state.yearToCalculate?.let { currentYear ->
            if (direction == 1) {
                yearComputed = currentYear + 1
                if (state.nextFlyingStarGroup != null) {
                    val previous = group!! // The current becomes the previous
                    val next = state.nextFlyingStarGroup!!.giveAdvancedFlyingStarGroup(1) as YearlyFlyingStarGroup

                    modifyState(
                        yearComputed,
                        state.nextFlyingStarGroup!!,
                        previous,
                        next
                    )

                    notifyUi()
                } else {
                    dispatcher.dispatch(ShowYearlyFlyingStarsAction.CalculateYearlyFlyingStars(yearComputed))
                }
            } else {
                yearComputed = currentYear - 1
                if (state.previousFlyingStarGroup != null) {
                    val previous = state.previousFlyingStarGroup!!.giveRewoundFlyingStarGroup(1, yearComputed) as YearlyFlyingStarGroup
                    val next = state.yearlyFlyingStarGroup!! // The current becomes the next

                    modifyState(
                        yearComputed,
                        state.previousFlyingStarGroup!!,
                        previous,
                        next
                    )

                    notifyUi()
                } else {
                    dispatcher.dispatch(ShowYearlyFlyingStarsAction.CalculateYearlyFlyingStars(yearComputed))
                }
            }
        }
    }


    private fun modifyState(
        currentYear: Int,
        currentFlyingStarGroup: YearlyFlyingStarGroup,
        previousYearlyFlyingStarGroup: YearlyFlyingStarGroup,
        nextFlyingStarGroup: YearlyFlyingStarGroup
    ) {
        state.reduce(IShowYearlyFlyingStarsState.MutateKeys.UpdateYear(currentYear))
        state.reduce(IShowYearlyFlyingStarsState.MutateKeys.UpdateYearlyFlyingStarGroup(currentFlyingStarGroup))
        state.reduce(
            IShowYearlyFlyingStarsState.MutateKeys.UpdatePreviousAndNextYearlyFlyingStarGroup(
                previousYearlyFlyingStarGroup,
                nextFlyingStarGroup
            )
        )
   }

    private fun notifyUi() {
        notifier.notify(ShowYearlyFlyingStarsNotifyResults.YearUpdated())
        notifier.notify(ShowYearlyFlyingStarsNotifyResults.YearlyFlyingStarGroupUpdated())
    }
}
