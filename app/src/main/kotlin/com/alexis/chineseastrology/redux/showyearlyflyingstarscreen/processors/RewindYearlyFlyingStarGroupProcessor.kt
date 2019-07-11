package com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.processors

import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.IShowYearlyFlyingStarsState
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.ShowYearlyFlyingStarsAction
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor

class RewindYearlyFlyingStarGroupProcessor(
        private val state: IShowYearlyFlyingStarsState,
        private val notifier: INotifier
) : BaseProcessor<IFlyingStarGroup?>() {
    override fun process(action: IAction): IFlyingStarGroup? {
        val actionCasted = action as ShowYearlyFlyingStarsAction.RewindYearlyFlyingStar
        val steps = actionCasted.steps
        val yearlyFlyingStarGroup = state.yearlyFlyingStarGroup
        yearlyFlyingStarGroup?.let {
            return it.giveRewoundFlyingStarGroup(steps)
        }
        return null
    }
}
