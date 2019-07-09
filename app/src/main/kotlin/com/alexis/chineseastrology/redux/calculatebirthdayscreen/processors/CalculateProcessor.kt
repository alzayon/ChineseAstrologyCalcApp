package com.alexis.chineseastrology.redux.calculatebirthdayscreen.processors

import com.alexis.chineseastrology.lib.IBdayCalculator
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.CalculateBirthdayNotifyResults
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.ICalculateBirthdayState
import com.alexis.redux.action.IAction
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.processor.BaseProcessor
import timber.log.Timber

class CalculateProcessor(
    private val notifier: INotifier,
    private val state: ICalculateBirthdayState,
    private val bdayCalculator: IBdayCalculator
) : BaseProcessor<Unit>() {
    override fun process(action: IAction) {
        state.birthdate?.let {
            val animalSign = bdayCalculator.calculate(it)
            Timber.d("Calcuate BaseNotifyResult %s", animalSign)
            notifier.notify(CalculateBirthdayNotifyResults.CalculationResult(animalSign))
        }
    }
}
