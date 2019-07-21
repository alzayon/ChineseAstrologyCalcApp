package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen

import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.redux.state.BaseState
import com.alexis.redux.state.IGetters
import com.alexis.redux.state.IMutateKey
import com.alexis.redux.state.IState
import java.text.DateFormatSymbols

interface IShowMonthlyFlyingStarsStateGetters : IGetters {
    val monthToCalculate: Int?
    val yearToCalculate: Int?
    val monthlyFlyingStarGroup: MonthlyFlyingStarGroup?
    val monthYearAsString: String?
    val previousFlyingStarGroup: MonthlyFlyingStarGroup?
    val nextFlyingStarGroup: MonthlyFlyingStarGroup?
}

interface IShowMonthlyFlyingStarsState : IState, IShowMonthlyFlyingStarsStateGetters {
    sealed class MutateKeys : IMutateKey {
        class UpdateMonthYear(val month: Int?, val year: Int?) : MutateKeys()
        class UpdateMonthlyFlyingStarGroup(val flyingStarGroup: MonthlyFlyingStarGroup?) : MutateKeys()
        class UpdateNextAndPreviousMonthlyFlyingStarGroup(
            val next: MonthlyFlyingStarGroup,
            val previous: MonthlyFlyingStarGroup
        ) : MutateKeys()
    }
}

class ShowMonthlyFlyingStarsState : BaseState(), IShowMonthlyFlyingStarsState {
    override var monthToCalculate: Int? = null
        private set

    override var yearToCalculate: Int? = null
        private set

    override var monthlyFlyingStarGroup: MonthlyFlyingStarGroup? = null
        private set

    override var previousFlyingStarGroup: MonthlyFlyingStarGroup? = null
        private set

    override var nextFlyingStarGroup: MonthlyFlyingStarGroup? = null
        private set

    override var monthYearAsString: String? = null
        get() {
            if (monthToCalculate != null && yearToCalculate != null) {
                val month = getMonthForInt(monthToCalculate!!)
                return "${month} / ${yearToCalculate}"
            }
            return null
        }

    override fun reduce(mutateKey: IMutateKey) {
        when (mutateKey) {
            is IShowMonthlyFlyingStarsState.MutateKeys.UpdateMonthYear -> {
                monthToCalculate = mutateKey.month
                yearToCalculate = mutateKey.year
            }
            is IShowMonthlyFlyingStarsState.MutateKeys.UpdateMonthlyFlyingStarGroup -> monthlyFlyingStarGroup = mutateKey.flyingStarGroup
            is IShowMonthlyFlyingStarsState.MutateKeys.UpdateNextAndPreviousMonthlyFlyingStarGroup -> {
                nextFlyingStarGroup = mutateKey.next
                previousFlyingStarGroup = mutateKey.previous
            }
            else -> throw IllegalArgumentException("Mutate key was not handled! " + mutateKey)
        }
    }

    override fun reset() {
        monthToCalculate = null
        yearToCalculate = null
        monthlyFlyingStarGroup = null
    }

    private fun getMonthForInt(num: Int): String {
        var month = "wrong"
        val dfs = DateFormatSymbols()
        val months = dfs.getMonths()
        if (num >= 0 && num <= 11) {
            month = months[num]
        }
        return month
    }
}