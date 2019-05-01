package com.alexis.redux.store

import com.alexis.redux.action.IAction
import com.alexis.redux.processor.IProcessor
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.state.IGetters

interface IStore {
    var notifier: INotifier
    fun resolveProcessor(action: IAction): IProcessor
    fun getters(): IGetters
}