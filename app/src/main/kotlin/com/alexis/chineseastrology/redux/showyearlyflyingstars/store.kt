package com.alexis.chineseastrology.redux.showyearlyflyingstars

import com.alexis.chineseastrology.redux.showyearlyflyingstars.processors.CalculateYearlyFlyingStarsProcessor
import com.alexis.chineseastrology.redux.showyearlyflyingstars.processors.MoveYearToCalculateProcessor
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.IProcessor
import com.alexis.redux.store.BaseStore
import com.alexis.redux.store.IStore

interface IShowYearlyFlyingStarsStore : IStore<IShowYearlyFlyingStarsState>

class ShowYearlyFlyingStarsStore(
    notifier: INotifier,
    state: IShowYearlyFlyingStarsState
) : BaseStore<IShowYearlyFlyingStarsState>(notifier, state), IShowYearlyFlyingStarsStore
{
    override fun resolveProcessor(action: IAction): IProcessor? {
        return when (action) {
            is ShowYearlyFlyingStarsAction.CalculateYearlyFlyingStars -> CalculateYearlyFlyingStarsProcessor(state, notifier)
            is ShowYearlyFlyingStarsAction.MoveYearToCalculate -> MoveYearToCalculateProcessor(state, this)
            else -> throw IllegalArgumentException("Action was not handled!")
        }
    }
}