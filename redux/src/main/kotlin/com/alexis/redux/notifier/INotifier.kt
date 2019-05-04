package com.alexis.redux.notifier

typealias NotifyListener = (INotifyResult) -> Unit

interface INotifier {
    fun notify(notifyResult: INotifyResult)
    fun listen(notifyListener: NotifyListener)
    fun cleanup()
}