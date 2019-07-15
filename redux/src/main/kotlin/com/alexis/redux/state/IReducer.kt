package com.alexis.redux.state

interface IReducer {
    fun reduce(mutateKey: IMutateKey)
}