package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroupSet
import com.alexis.chineseastrology.redux.notifier.LiveDataNotifier
import com.alexis.chineseastrology.redux.showyearlyflyingstars.*
import com.alexis.redux.notifier.INotifyResult
import java.util.*
import javax.inject.Inject

class ShowYearlyFlyingStarsViewModel @Inject constructor() : ViewModel() {
    private val lv = MutableLiveData<INotifyResult>()

    private lateinit var notifier: LiveDataNotifier
    private lateinit var state: IShowYearlyFlyingStarsState

    lateinit var store: IShowYearlyFlyingStarsStore
        private set

    fun setup(lifecycleOwner: LifecycleOwner) {
        notifier = LiveDataNotifier()
        notifier.setup(lifecycleOwner)
        state = ShowYearlyFlyingStarsState()
        store = ShowYearlyFlyingStarsStore(notifier, state)
    }
}