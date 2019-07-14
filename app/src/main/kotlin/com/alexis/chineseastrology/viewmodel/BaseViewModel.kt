package com.alexis.chineseastrology.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.alexis.chineseastrology.redux.notifier.LiveDataNotifier

open abstract class BaseViewModel : ViewModel() {
    protected lateinit var notifier: LiveDataNotifier
        private set

    open fun setup(lifecycleOwner: LifecycleOwner) {
        notifier = LiveDataNotifier()
        notifier.setup(lifecycleOwner)
    }

    override fun onCleared() {
        super.onCleared()
    }
}