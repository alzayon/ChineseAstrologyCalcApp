package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen

import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.redux.state.IGetters
import com.alexis.redux.state.IMutateKey
import com.alexis.redux.state.IState

interface IShowYearlyFlyingStarsStateGetters : IGetters {
    val yearToCalculate: Int?
    val yearlyFlyingStarGroup: YearlyFlyingStarGroup?
}

interface IShowYearlyFlyingStarsState : IState, IShowYearlyFlyingStarsStateGetters  {
    sealed class MutateKeys : IMutateKey {
        class UpdateYear(val year: Int?) : MutateKeys()
        class UpdateYearlyFlyingStarGroup(val flyingStarGroup: YearlyFlyingStarGroup?) : MutateKeys()
    }
}

class ShowYearlyFlyingStarsState : IShowYearlyFlyingStarsState {
    override var yearToCalculate: Int? = null
        private set

    override var yearlyFlyingStarGroup: YearlyFlyingStarGroup? = null
        private set

    override fun reduce(mutateKey: IMutateKey) {
        when (mutateKey) {
            is IShowYearlyFlyingStarsState.MutateKeys.UpdateYear -> yearToCalculate = mutateKey.year
            is IShowYearlyFlyingStarsState.MutateKeys.UpdateYearlyFlyingStarGroup -> yearlyFlyingStarGroup = mutateKey.flyingStarGroup
            else -> throw IllegalArgumentException("Mutate key was not handled! " + mutateKey)
        }
    }

    override fun reset() {
        yearToCalculate = null
        yearlyFlyingStarGroup = null
    }
}