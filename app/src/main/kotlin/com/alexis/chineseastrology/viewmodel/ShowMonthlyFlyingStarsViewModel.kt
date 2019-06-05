package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroupSet
import com.alexis.chineseastrology.redux.notifier.LiveDataNotifier
import com.alexis.chineseastrology.redux.showmonthlyflyingstars.IShowMonthlyFlyingStarsState
import com.alexis.chineseastrology.redux.showmonthlyflyingstars.IShowMonthlyFlyingStarsStore
import com.alexis.chineseastrology.redux.showmonthlyflyingstars.ShowMonthlyFlyingStarsState
import com.alexis.chineseastrology.redux.showmonthlyflyingstars.ShowMonthlyFlyingStarsStore
import com.alexis.chineseastrology.redux.showyearlyflyingstars.IShowYearlyFlyingStarsState
import com.alexis.chineseastrology.redux.showyearlyflyingstars.IShowYearlyFlyingStarsStore
import com.alexis.chineseastrology.redux.showyearlyflyingstars.ShowYearlyFlyingStarsState
import com.alexis.chineseastrology.redux.showyearlyflyingstars.ShowYearlyFlyingStarsStore
import com.alexis.redux.notifier.INotifyResult
import java.util.*
import javax.inject.Inject

class ShowMonthlyFlyingStarsViewModel @Inject constructor() : ViewModel() {
    private val lv = MutableLiveData<INotifyResult>()

    private lateinit var notifier: LiveDataNotifier
    private lateinit var state: IShowMonthlyFlyingStarsState

    lateinit var store: IShowMonthlyFlyingStarsStore
        private set

    fun setup(lifecycleOwner: LifecycleOwner) {
        notifier = LiveDataNotifier()
        notifier.setup(lifecycleOwner)
        state = ShowMonthlyFlyingStarsState()
        store = ShowMonthlyFlyingStarsStore(notifier, state)
    }
}