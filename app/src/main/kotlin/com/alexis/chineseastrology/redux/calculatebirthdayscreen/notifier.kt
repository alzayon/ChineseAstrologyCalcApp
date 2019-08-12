package com.alexis.chineseastrology.redux.calculatebirthdayscreen

import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import com.alexis.redux.notifier.BaseNotifyResult

sealed class NotifyResults : BaseNotifyResult() {
    class UpdateSelectedDate : NotifyResults()
    class CalculationResult(val animalSign: IAnimalSign) : NotifyResults()
}