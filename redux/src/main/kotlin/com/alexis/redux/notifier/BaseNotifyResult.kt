package com.alexis.redux.notifier

abstract class BaseNotifyResult : INotifyResult {
    private var consumed = false
    override fun consume() {
        consumed = true
    }
    override fun isConsumed(): Boolean {
        return consumed
    }
}