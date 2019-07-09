package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen

import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.processors.CalculateYearlyFlyingStarsProcessor
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.processors.MoveYearToCalculateProcessor
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor
import com.alexis.redux.processor.IProcessor
import com.alexis.redux.state.IGetters
import com.alexis.redux.store.BaseStore
import com.alexis.redux.store.IStore

interface IShowYearlyFlyingStarsStore : IStore

class ShowYearlyFlyingStarsStore(
    notifier: INotifier,
    state: IShowYearlyFlyingStarsState
) : BaseStore<IShowYearlyFlyingStarsState>(notifier, state), IShowYearlyFlyingStarsStore
{
    override fun resolveProcessor(action: IAction): IProcessor<Any> {
        return when (action) {
            is ShowYearlyFlyingStarsAction.CalculateYearlyFlyingStars -> CalculateYearlyFlyingStarsProcessor(state, notifier)
            is ShowYearlyFlyingStarsAction.MoveYearToCalculate -> MoveYearToCalculateProcessor(state, this)
            else -> throw IllegalArgumentException("Action was not handled!")
        } as IProcessor<Any>
    }

    override fun getters(): IGetters {
        return state
    }
}