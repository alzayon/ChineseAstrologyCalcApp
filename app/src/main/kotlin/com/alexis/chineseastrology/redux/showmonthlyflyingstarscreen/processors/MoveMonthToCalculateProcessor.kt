package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.processors

import com.alexis.chineseastrology.helpers.ifLet
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.IShowMonthlyFlyingStarsState
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsAction
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsNotifyResults
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor
import com.alexis.redux.store.IDispatcher

class MoveMonthToCalculateProcessor(
    private val state: IShowMonthlyFlyingStarsState,
    private val dispatcher: IDispatcher,
    private val notifier: INotifier
) : BaseProcessor<Unit>() {
    override fun process(action: IAction) {
        val actionCasted = action as ShowMonthlyFlyingStarsAction.MoveMonthToCalculate
        val direction = actionCasted.movement
        val group = state.monthlyFlyingStarGroup

        ifLet (state.monthToCalculate, state.yearToCalculate) { (month, year) ->
            var monthComputed = month
            var yearComputed = year
            if (direction == 1) {
                monthComputed = month + 1
                if (monthComputed > 11) {
                    monthComputed = 0
                    yearComputed = year + 1
                }

                if (state.nextFlyingStarGroup != null) {
                    val previous = group!! // The current becomes the previous
                    val next = state.nextFlyingStarGroup!!.giveAdvancedFlyingStarGroup(1) as MonthlyFlyingStarGroup
                    modifyState(
                        monthComputed,
                        yearComputed,
                        state.nextFlyingStarGroup!!,
                        previous,
                        next
                    )

                    notifyUi()
                } else {
                    dispatcher.dispatch(ShowMonthlyFlyingStarsAction.CalculateMonthlyFlyingStars(monthComputed, yearComputed))
                }
            } else {
                monthComputed = month - 1
                if (monthComputed < 0) {
                    monthComputed = 11
                    yearComputed = year - 1
                }

                if (state.previousFlyingStarGroup != null) {
                    val previous = state.previousFlyingStarGroup!!.giveRewoundFlyingStarGroup(1) as MonthlyFlyingStarGroup
                    val next = group!! // The current becomes the next
                    modifyState(
                            monthComputed,
                            yearComputed,
                            state.previousFlyingStarGroup!!,
                            previous,
                            next
                    )

                    notifyUi()
                } else {
                    dispatcher.dispatch(ShowMonthlyFlyingStarsAction.CalculateMonthlyFlyingStars(monthComputed, yearComputed))
                }
            }
        }
    }

    private fun modifyState(
        month: Int,
        year: Int,
        currentFlyingStarGroup: MonthlyFlyingStarGroup,
        previousFlyingStarGroup: MonthlyFlyingStarGroup,
        nextFlyingStarGroup: MonthlyFlyingStarGroup
    ) {
        state.reduce(IShowMonthlyFlyingStarsState.MutateKeys.UpdateMonthYear(month, year))
        state.reduce(IShowMonthlyFlyingStarsState.MutateKeys.UpdateMonthlyFlyingStarGroup(currentFlyingStarGroup))
        state.reduce(
            IShowMonthlyFlyingStarsState.MutateKeys.UpdatePreviousAndNextMonthlyFlyingStarGroup(
                previousFlyingStarGroup,
                nextFlyingStarGroup
            )
        )
    }

    private fun notifyUi() {
        notifier.notify(ShowMonthlyFlyingStarsNotifyResults.MonthYearUpdated())
        notifier.notify(ShowMonthlyFlyingStarsNotifyResults.MonthlyFlyingStarGroupUpdated())
    }
}
