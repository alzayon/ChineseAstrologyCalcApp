package com.alexis.redux.processor

import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.store.IDispatcher

interface IProcessor {
    var notifier: INotifier
    var dispatcher: IDispatcher

    fun process(action: IAction)
}