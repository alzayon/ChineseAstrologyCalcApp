package com.alexis.chineseastrology.redux.calculatebirthdayscreen

import com.alexis.chineseastrology.lib.IBdayCalculator
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.processors.CalculateProcessor
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.processors.SetBirthdateProcessor
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.IProcessor
import com.alexis.redux.store.BaseStore
import com.alexis.redux.store.IStore

interface ICalculateBirthdayStore : IStore

class CalculateBirthdayStore(
    notifier: INotifier,
    state: ICalculateBirthdayState,
    private val bdayCalculator: IBdayCalculator
) : BaseStore<ICalculateBirthdayState>(notifier, state), ICalculateBirthdayStore
{
    override fun resolveProcessor(action: IAction): IProcessor<Any, IAction> {
        return when (action) {
            is Actions.SetBirthdate -> SetBirthdateProcessor(notifier, state)
            is Actions.Calculate -> CalculateProcessor(notifier, state, bdayCalculator)
            else -> throw IllegalArgumentException("Action was not handled!")
        } as IProcessor<Any, IAction>
    }

    override fun getters(): ICalculateBirthdayStateGetters {
        return state
    }
}