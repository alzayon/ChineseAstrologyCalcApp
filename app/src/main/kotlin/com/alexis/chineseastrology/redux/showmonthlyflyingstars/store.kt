package com.alexis.chineseastrology.redux.showmonthlyflyingstars

import com.alexis.chineseastrology.redux.showmonthlyflyingstars.processors.CalculateMonthlyFlyingStarsProcessor
import com.alexis.chineseastrology.redux.showmonthlyflyingstars.processors.MoveMonthToCalculateProcessor
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.IProcessor
import com.alexis.redux.store.BaseStore
import com.alexis.redux.store.IStore

interface IShowMonthlyFlyingStarsStore : IStore<IShowMonthlyFlyingStarsState>

class ShowMonthlyFlyingStarsStore(
    notifier: INotifier,
    state: IShowMonthlyFlyingStarsState
) : BaseStore<IShowMonthlyFlyingStarsState>(notifier, state), IShowMonthlyFlyingStarsStore {
    override fun resolveProcessor(action: IAction): IProcessor? {
        return when (action) {
            is ShowMonthlyFlyingStarsAction.CalculateMonthlyFlyingStars -> CalculateMonthlyFlyingStarsProcessor(state, notifier)
            is ShowMonthlyFlyingStarsAction.MoveYearToCalculate -> MoveMonthToCalculateProcessor(state, this)
            else -> throw IllegalArgumentException("Action was not handled!")
        }
    }
}