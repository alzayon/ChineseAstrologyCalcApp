package com.alexis.chineseastrology.viewmodel

import android.arch.lifecycle.ViewModel

open abstract class BaseViewModel : ViewModel() {
    override fun onCleared() {
        super.onCleared()
    }
}