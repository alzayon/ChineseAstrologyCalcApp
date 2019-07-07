package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen

import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.redux.state.BaseState
import com.alexis.redux.state.IGetters
import com.alexis.redux.state.IMutateKey
import com.alexis.redux.state.IState

interface IShowMonthlyFlyingStarsStateGetters : IGetters {
    val monthToCalculate: Int?
    val yearToCalculate: Int?
    val monthlyFlyingStarGroup: MonthlyFlyingStarGroup?
}

interface IShowMonthlyFlyingStarsState : IState, IShowMonthlyFlyingStarsStateGetters {
    sealed class MutateKeys : IMutateKey {
        class UpdateMonthYear(val month: Int?, val year: Int?) : MutateKeys()
        class UpdateMonthlyFlyingStarGroup(val flyingStarGroup: MonthlyFlyingStarGroup?) : MutateKeys()
    }
}

class ShowMonthlyFlyingStarsState : BaseState(), IShowMonthlyFlyingStarsState {
    override var monthToCalculate: Int? = null
        private set

    override var yearToCalculate: Int? = null
        private set

    override var monthlyFlyingStarGroup: MonthlyFlyingStarGroup? = null
        private set

    override fun reduce(mutateKey: IMutateKey) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reset() {
        monthToCalculate = null
        yearToCalculate = null
        monthlyFlyingStarGroup = null
    }
}