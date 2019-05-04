package com.alexis.redux.store

import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.BaseNotifyResult
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.notifier.INotifyResult
import com.alexis.redux.notifier.INotifyResultListener
import com.alexis.redux.processor.IProcessor
import com.alexis.redux.state.IState

interface IStore<T: IState> : IDispatcher, INotifier {
    val notifier: INotifier
    val state: T
    fun resolveProcessor(action: IAction): IProcessor?
    fun reset()
}