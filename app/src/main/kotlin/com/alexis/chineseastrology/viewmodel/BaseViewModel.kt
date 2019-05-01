package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.notifier.INotifyResult

class BaseViewModel : ViewModel(), IChastroViewModel, INotifier {
    private var unconsumedResults = mutableListOf<INotifyResult>()
    private val _Notify_resultLv: MutableLiveData<INotifyResult> = MutableLiveData()
    public val notifyResultLv: LiveData<INotifyResult> = _Notify_resultLv

    override fun notify(notifyResult: INotifyResult) {
        if (!_Notify_resultLv.hasActiveObservers()) {
            unconsumedResults.add(notifyResult)
        } else {
            _Notify_resultLv.value = notifyResult
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}