package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen

import com.alexis.redux.action.IAction

sealed class ShowYearlyFlyingStarsAction : IAction {
    class CalculateYearlyFlyingStars(
        val year: Int? = null,
        val userInitiated: Boolean = false
    ) : ShowYearlyFlyingStarsAction()
    class MoveYearToCalculate(val movement: Int) : ShowYearlyFlyingStarsAction()
}
