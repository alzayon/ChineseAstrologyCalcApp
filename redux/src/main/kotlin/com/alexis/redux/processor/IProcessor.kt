package com.alexis.redux.processor

import com.alexis.redux.result.INotifier
import com.alexis.redux.store.IDispatcher

interface IProcessor {
    var notifier: INotifier
    var dispatcher: IDispatcher
}