package com.alexis.chineseastrology.redux.calculatebirthdayscreen

import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import com.alexis.redux.notifier.BaseNotifyResult

sealed class CalculateBirthdayNotifyResults : BaseNotifyResult() {
    class UpdateSelectedDate : CalculateBirthdayNotifyResults()
    class CalculationResult(val animalSign: IAnimalSign) : CalculateBirthdayNotifyResults()
}