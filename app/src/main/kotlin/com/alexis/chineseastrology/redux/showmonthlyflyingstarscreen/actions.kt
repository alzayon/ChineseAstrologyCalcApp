package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen

import com.alexis.redux.action.IAction

sealed class ShowMonthlyFlyingStarsAction : IAction {
    class CalculateMonthlyFlyingStars(
        val month: Int? = null,
        val year: Int? = null,
        val userInitiated: Boolean = false
    ) : ShowMonthlyFlyingStarsAction()
    class MoveMonthToCalculate(val movement: Int) : ShowMonthlyFlyingStarsAction()
    class AdvanceMonthlyFlyingStar(val steps: Int = 1) : ShowMonthlyFlyingStarsAction()
    class RewindMonthlyFlyingStar(val steps: Int = 1) : ShowMonthlyFlyingStarsAction()
}