package com.alexis.chineseastrology.redux.showyearlyflyingstars.processors

import com.alexis.chineseastrology.redux.showyearlyflyingstars.IShowYearlyFlyingStarsState
import com.alexis.chineseastrology.redux.showyearlyflyingstars.ShowYearlyFlyingStarsAction
import com.alexis.redux.action.IAction
import com.alexis.redux.processor.BaseProcessor
import com.alexis.redux.store.IDispatcher

class MoveYearToCalculateProcessor(
    private val state: IShowYearlyFlyingStarsState,
    private val dispatcher: IDispatcher
) : BaseProcessor() {
    override fun process(action: IAction) {
        val actionCasted = action as ShowYearlyFlyingStarsAction.MoveYearToCalculate
        val direction = actionCasted.movement
        state.yearToCalculate?.let {
            var yearComputed = 0
            if (direction == 1) {
                yearComputed = it.inc()
            } else {
                yearComputed = it.dec()
            }
            dispatcher.dispatch(ShowYearlyFlyingStarsAction.CalculateYearlyFlyingStars(yearComputed))
        }
    }
}
