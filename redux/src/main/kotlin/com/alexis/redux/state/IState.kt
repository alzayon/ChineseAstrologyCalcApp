package com.alexis.redux.state

interface IState {
    fun mutate(mutateKey: IMutateKey)
}