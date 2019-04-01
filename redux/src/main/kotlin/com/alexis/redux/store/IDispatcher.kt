package com.alexis.redux.store

import com.alexis.redux.action.IAction

interface IDispatcher {
    fun dispatch(action: IAction)
}

