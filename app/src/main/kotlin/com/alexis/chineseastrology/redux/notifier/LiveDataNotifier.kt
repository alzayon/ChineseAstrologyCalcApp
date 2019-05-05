package com.alexis.chineseastrology.redux.notifier

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.notifier.INotifyResult
import com.alexis.redux.notifier.NotifyListener

class LiveDataNotifier() : INotifier {
    private var _liveData: MutableLiveData<INotifyResult> = MutableLiveData()
    private val unconsumedResultsList: MutableList<INotifyResult> = mutableListOf()
    private lateinit var lifecycleOwner: LifecycleOwner

    fun setup(owner: LifecycleOwner) {
        lifecycleOwner = owner
    }

    override fun notify(notifyResult: INotifyResult) {
        if (!_liveData.hasActiveObservers()) {
            unconsumedResultsList.add(notifyResult)
        } else {

        }
        _liveData.value = notifyResult

        // IMPORTANT
        notifyResult.consume()
    }

    override fun listen(notifyListener: NotifyListener) {
        _liveData.observe(lifecycleOwner, Observer { result ->
            result?.let {
                notifyListener(it)
            }
        })
    }

    override fun cleanup() {
        _liveData.removeObservers(lifecycleOwner)
    }

    // TODO
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