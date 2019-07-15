package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen

import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.processors.AdvanceMonthlyFlyingStarGroupProcessor
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.processors.CalculateMonthlyFlyingStarsProcessor
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.processors.MoveMonthToCalculateProcessor
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.processors.RewindMonthlyFlyingStarGroupProcessor
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
    override fun resolveProcessor(action: IAction): IProcessor<Any> {
        return when (action) {
            is ShowMonthlyFlyingStarsAction.CalculateMonthlyFlyingStars ->
                CalculateMonthlyFlyingStarsProcessor(state, notifier)
            is ShowMonthlyFlyingStarsAction.MoveMonthToCalculate ->
                MoveMonthToCalculateProcessor(state, this)
            is ShowMonthlyFlyingStarsAction.AdvanceMonthlyFlyingStar ->
                AdvanceMonthlyFlyingStarGroupProcessor(state, this)
            is ShowMonthlyFlyingStarsAction.RewindMonthlyFlyingStar ->
                RewindMonthlyFlyingStarGroupProcessor(state, this)
            else -> throw IllegalArgumentException("Action was not handled!")
        } as IProcessor<Any>
    }

    override fun getters(): IGetters {
        return state
    }
}