package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen

import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.redux.state.BaseState
import com.alexis.redux.state.IGetters
import com.alexis.redux.state.IMutateKey
import com.alexis.redux.state.IState

interface IShowYearlyFlyingStarsStateGetters : IGetters {
    val yearToCalculate: Int?
    val yearlyFlyingStarGroup: YearlyFlyingStarGroup?
    val previousFlyingStarGroup: YearlyFlyingStarGroup?
    val nextFlyingStarGroup: YearlyFlyingStarGroup?
}

sealed class MutateKeys : IMutateKey {
    class UpdateYear(val year: Int?) : MutateKeys()
    class UpdateYearlyFlyingStarGroup(val flyingStarGroup: YearlyFlyingStarGroup) : MutateKeys()
    class UpdatePreviousAndNextYearlyFlyingStarGroup(
            val previous: YearlyFlyingStarGroup,
            val next: YearlyFlyingStarGroup
    ) : MutateKeys()
}

interface IShowYearlyFlyingStarsState : IState, IShowYearlyFlyingStarsStateGetters

class ShowYearlyFlyingStarsState : BaseState(), IShowYearlyFlyingStarsState {
    override var yearToCalculate: Int? = null
        private set

    override var yearlyFlyingStarGroup: YearlyFlyingStarGroup? = null
        private set

    override var previousFlyingStarGroup: YearlyFlyingStarGroup? = null
        private set

    override var nextFlyingStarGroup: YearlyFlyingStarGroup? = null
        private set

    override fun reduce(mutateKey: IMutateKey) {
        when (mutateKey) {
            is MutateKeys.UpdateYear -> yearToCalculate = mutateKey.year
            is MutateKeys.UpdateYearlyFlyingStarGroup -> yearlyFlyingStarGroup = mutateKey.flyingStarGroup
            is MutateKeys.UpdatePreviousAndNextYearlyFlyingStarGroup -> {
                nextFlyingStarGroup = mutateKey.next
                previousFlyingStarGroup = mutateKey.previous
            }
            else -> throw IllegalArgumentException("Mutate key was not handled! " + mutateKey)
        }
    }

    override fun reset() {
        yearToCalculate = null
        yearlyFlyingStarGroup = null
    }
}