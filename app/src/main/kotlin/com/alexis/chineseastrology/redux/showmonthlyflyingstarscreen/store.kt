package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen

import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.processors.CalculateMonthlyFlyingStarsProcessor
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.processors.MoveMonthToCalculateProcessor
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.IProcessor
import com.alexis.redux.state.IGetters
import com.alexis.redux.store.BaseStore
import com.alexis.redux.store.IStore

interface IShowMonthlyFlyingStarsStore : IStore

class ShowMonthlyFlyingStarsStore(
    notifier: INotifier,
    state: IShowMonthlyFlyingStarsState
) : BaseStore<IShowMonthlyFlyingStarsState>(notifier, state), IShowMonthlyFlyingStarsStore {
    override fun resolveProcessor(action: IAction): IProcessor<Any, IAction> {
        return when (action) {
            is Actions.CalculateMonthlyFlyingStars ->
                CalculateMonthlyFlyingStarsProcessor(state, notifier)
            is Actions.MoveMonthToCalculate ->
                MoveMonthToCalculateProcessor(state, this, notifier)
            else -> throw IllegalArgumentException("Action was not handled!")
        } as IProcessor<Any, IAction>
    }

    override fun getters(): IGetters {
        return state
    }
}