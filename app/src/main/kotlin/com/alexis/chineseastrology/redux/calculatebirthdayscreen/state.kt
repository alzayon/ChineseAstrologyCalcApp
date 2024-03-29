package com.alexis.chineseastrology.redux.calculatebirthdayscreen

import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import com.alexis.redux.state.BaseState
import com.alexis.redux.state.IGetters
import com.alexis.redux.state.IMutateKey
import com.alexis.redux.state.IState
import java.util.*

interface ICalculateBirthdayStateGetters : IGetters {
    val birthdate: Date?
    val animalSign: IAnimalSign?
}

sealed class MutateKeys : IMutateKey {
    class SetBirthdate(val date: Date?) : MutateKeys()
    class SetAnimalSign(val animalSign: IAnimalSign?) : MutateKeys()
}

interface ICalculateBirthdayState : IState, ICalculateBirthdayStateGetters

class CalculateBirthdayState : BaseState(), ICalculateBirthdayState {
    override var birthdate: Date? = null
        private set
    override var animalSign: IAnimalSign? = null
        private set

    override fun reduce(mutateKey: IMutateKey) {
        when (mutateKey) {
            is MutateKeys.SetBirthdate -> { this.birthdate = mutateKey.date }
            is MutateKeys.SetAnimalSign -> { this.animalSign = mutateKey.animalSign }
            else -> throw IllegalArgumentException("Mutate key was not handled! " + mutateKey)
        }
    }

    override fun reset() {
        this.birthdate = null
        this.animalSign = null
    }
}
