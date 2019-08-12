package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen

import com.alexis.redux.action.IAction

sealed class Actions : IAction {
    class CalculateYearlyFlyingStars(
        val year: Int? = null,
        val userInitiated: Boolean = false
    ) : Actions()
    class MoveYearToCalculate(val movement: Int) : Actions()
}
