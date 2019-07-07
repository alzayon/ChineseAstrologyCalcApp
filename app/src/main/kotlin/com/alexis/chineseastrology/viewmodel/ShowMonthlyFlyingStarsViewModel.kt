package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.LifecycleOwner
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.IShowMonthlyFlyingStarsState
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.IShowMonthlyFlyingStarsStore
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsState
import com.alexis.chineseastrology.redux.showmonthlyflyingstarscreen.ShowMonthlyFlyingStarsStore
import javax.inject.Inject

class ShowMonthlyFlyingStarsViewModel @Inject constructor() : BaseViewModel() {
    private lateinit var state: IShowMonthlyFlyingStarsState

    lateinit var store: IShowMonthlyFlyingStarsStore
        private set

    override fun setup(lifecycleOwner: LifecycleOwner) {
        super.setup(lifecycleOwner)
        state = ShowMonthlyFlyingStarsState()
        store = ShowMonthlyFlyingStarsStore(notifier, state)
    }
}