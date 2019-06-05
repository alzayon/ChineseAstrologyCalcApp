package com.alexis.chineseastrology.redux.showmonthlyflyingstars.processors

import com.alexis.chineseastrology.redux.showmonthlyflyingstars.IShowMonthlyFlyingStarsState
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor

class MoveMonthToCalculateProcessor(
    private val state: IShowMonthlyFlyingStarsState,
    private val notifier: INotifier
) : BaseProcessor() {
    override fun process(action: IAction) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
