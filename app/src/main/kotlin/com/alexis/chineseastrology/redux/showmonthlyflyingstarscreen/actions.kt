package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen

import com.alexis.redux.action.IAction

sealed class ShowMonthlyFlyingStarsAction : IAction {
    class CalculateMonthlyFlyingStars(
        val year: Int? = null,
        val month: Int? = null,
        val userInitiated: Boolean = false
    ) : ShowMonthlyFlyingStarsAction()
    class MoveYearToCalculate(val movement: Int) : ShowMonthlyFlyingStarsAction()
}