package com.alexis.chineseastrology.redux.notifier

import android.arch.lifecycle.MutableLiveData
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.notifier.INotifyResult

class LiveDataNotifier : INotifier {
    private var _liveData: MutableLiveData<INotifyResult> = MutableLiveData()
    private val unconsumedResultsList: MutableList<INotifyResult> = mutableListOf()

    override fun notify(notifyResult: INotifyResult) {
        if (!_liveData.hasActiveObservers()) {
            unconsumedResultsList.add(notifyResult)
        } else {

        }
        _liveData.value = notifyResult
    }

    fun consumePendingUiModels() {
        if (unconsumedResultsList.isNotEmpty()) {
            var tmpList = unconsumedResultsList.toList()
            unconsumedResultsList.clear()

            tmpList.forEach {
                _liveData.value = it
            }
        }
    }
}