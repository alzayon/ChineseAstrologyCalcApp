package com.alexis.chineseastrology.redux.calculatebirthdayscreen

import com.alexis.redux.action.IAction
import java.util.*

sealed class CalculateBirthdayActions : IAction {
    class SetBirthdate(val birthdate: Date?) : CalculateBirthdayActions()
    object ResetState : CalculateBirthdayActions()
    object Calculate  : CalculateBirthdayActions()
}
