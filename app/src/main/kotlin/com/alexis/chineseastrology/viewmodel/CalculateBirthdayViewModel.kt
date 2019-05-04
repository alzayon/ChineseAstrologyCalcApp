package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import com.alexis.chineseastrology.lib.IBdayCalculator
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.CalculateBirthdayState
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.CalculateBirthdayStore
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.ICalculateBirthdayState
import com.alexis.chineseastrology.redux.calculatebirthdayscreen.ICalculateBirthdayStore
import com.alexis.chineseastrology.redux.notifier.LiveDataNotifier
import com.alexis.redux.notifier.INotifyResult
import javax.inject.Inject

class CalculateBirthdayViewModel @Inject constructor(private val bdayCalculator: IBdayCalculator) :
        BaseViewModel() {

    private val lv = MutableLiveData<INotifyResult>()

    private lateinit var notifier: LiveDataNotifier
    private lateinit var state: ICalculateBirthdayState

    lateinit var store: ICalculateBirthdayStore
        private set

    fun setup(lifecycleOwner: LifecycleOwner) {
        notifier = LiveDataNotifier()
        notifier.setup(lifecycleOwner)
        state = CalculateBirthdayState()
        store = CalculateBirthdayStore(notifier, state, bdayCalculator)
    }
}