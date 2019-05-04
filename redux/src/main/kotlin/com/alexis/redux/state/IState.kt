package com.alexis.redux.state

interface IState {
    fun reduce(mutateKey: IMutateKey)
    fun reset()
}