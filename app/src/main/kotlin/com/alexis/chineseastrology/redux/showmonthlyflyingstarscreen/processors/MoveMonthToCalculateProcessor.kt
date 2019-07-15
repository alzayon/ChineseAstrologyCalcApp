package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.processors

import com.alexis.chineseastrology.helpers.ifLet
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.IShowMonthlyFlyingStarsState
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsAction
import com.alexis.redux.action.IAction
import com.alexis.redux.processor.BaseProcessor
import com.alexis.redux.store.IDispatcher

class MoveMonthToCalculateProcessor(
    private val state: IShowMonthlyFlyingStarsState,
    private val dispatcher: IDispatcher
) : BaseProcessor<Unit>() {
    override fun process(action: IAction) {
        val actionCasted = action as ShowMonthlyFlyingStarsAction.MoveMonthToCalculate
        val direction = actionCasted.movement
        ifLet (state.monthToCalculate, state.yearToCalculate) { (month, year) ->
            var monthComputed = month
            var yearComputed = year
            if (direction == 1) {
                // TODO use reduce()
                monthComputed = month.inc()
                if (monthComputed > 11) {
                    monthComputed = 0
                    // month = 0
                    year.inc()
                }
            } else {
                // TODO use reduce()
                monthComputed = month.dec()
                if (monthComputed < 0) {
                    monthComputed = 11
                    // month = 11
                    year.dec()
                }
            }
            dispatcher.dispatch(ShowMonthlyFlyingStarsAction.CalculateMonthlyFlyingStars(monthComputed, yearComputed))
        }
    }
}
