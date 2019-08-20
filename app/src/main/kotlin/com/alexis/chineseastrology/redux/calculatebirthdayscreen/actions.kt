package com.alexis.chineseastrology.redux.calculatebirthdayscreen

import com.alexis.redux.action.IAction
import java.util.*

sealed class Actions : IAction {
    class SetBirthdate(val birthdate: Date?) : Actions()
    object Calculate  : Actions()
}
