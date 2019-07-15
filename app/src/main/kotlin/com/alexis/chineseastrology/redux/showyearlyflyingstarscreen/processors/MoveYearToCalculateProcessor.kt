package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.processors

import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.IShowYearlyFlyingStarsState
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.ShowYearlyFlyingStarsAction
import com.alexis.redux.action.IAction
import com.alexis.redux.processor.BaseProcessor
import com.alexis.redux.store.IDispatcher

class MoveYearToCalculateProcessor(
    private val state: IShowYearlyFlyingStarsState,
    private val dispatcher: IDispatcher
) : BaseProcessor<Unit>() {
    override fun process(action: IAction) {
        val actionCasted = action as ShowYearlyFlyingStarsAction.MoveYearToCalculate
        val direction = actionCasted.movement
        state.yearToCalculate?.let {
            var yearComputed = 0
            if (direction == 1) {
                // TODO use reduce()
                yearComputed = it.inc()
            } else {
                // TODO use reduce()
                yearComputed = it.dec()
            }
            dispatcher.dispatch(ShowYearlyFlyingStarsAction.CalculateYearlyFlyingStars(yearComputed))
        }
    }
}
