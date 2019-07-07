package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.LifecycleOwner
import com.alexis.chineseastrology.redux.showyearlyflyingstarscreen.*
import javax.inject.Inject

class ShowYearlyFlyingStarsViewModel @Inject constructor() : BaseViewModel() {
    private lateinit var state: IShowYearlyFlyingStarsState

    lateinit var store: IShowYearlyFlyingStarsStore
        private set

    override fun setup(lifecycleOwner: LifecycleOwner) {
        super.setup(lifecycleOwner)
        state = ShowYearlyFlyingStarsState()
        store = ShowYearlyFlyingStarsStore(notifier, state)
    }
}