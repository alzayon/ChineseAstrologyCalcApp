package com.alexis.chineseastrology.redux.calculatebirthdayscreen.processors

import com.alexis.chineseastrology.redux.calculatebirthdayscreen.Actions
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.NotifyResults
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.ICalculateBirthdayState
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.MutateKeys
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor

class SetBirthdateProcessor(
    private val notifier: INotifier,
    private val state: ICalculateBirthdayState
) : BaseProcessor<Unit>() {
    override fun process(action: IAction) {
        val actionCasted = action as Actions.SetBirthdate
        state.reduce(MutateKeys.SetBirthdate(actionCasted.birthdate))
        notifier.notify(NotifyResults.UpdateSelectedDate())
    }
}