package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen

import com.alexis.redux.action.IAction

sealed class Actions : IAction {
    class CalculateMonthlyFlyingStars(
        val month: Int? = null,
        val year: Int? = null,
        val userInitiated: Boolean = false
    ) : Actions()
    class MoveMonthToCalculate(val movement: Int) : Actions()
}