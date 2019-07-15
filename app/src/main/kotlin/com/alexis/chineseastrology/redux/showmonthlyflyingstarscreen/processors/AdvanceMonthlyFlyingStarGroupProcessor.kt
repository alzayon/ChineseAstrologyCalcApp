package com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.processors

import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.IShowMonthlyFlyingStarsState
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsAction
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor

class AdvanceMonthlyFlyingStarGroupProcessor(
    private val state: IShowMonthlyFlyingStarsState,
    private val notifier: INotifier
) : BaseProcessor<IFlyingStarGroup?>() {
    override fun process(action: IAction): IFlyingStarGroup? {
        val actionCasted = action as ShowMonthlyFlyingStarsAction.AdvanceMonthlyFlyingStar
        val steps = actionCasted.steps
        val monthlyFlyingStarGroup = state.monthlyFlyingStarGroup
        monthlyFlyingStarGroup?.let {
            return it.giveAdvancedFlyingStarGroup(steps)
        }
        return null
    }
}