package com.alexis.redux.store

import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.IProcessor
import com.alexis.redux.state.IGetters

interface IStore : IDispatcher, INotifier {
    fun resolveProcessor(action: IAction): IProcessor<Any, IAction>
    fun reset()
    fun getters(): IGetters
}
