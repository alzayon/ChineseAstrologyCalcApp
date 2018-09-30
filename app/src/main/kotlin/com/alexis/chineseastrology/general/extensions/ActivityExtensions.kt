package com.alexis.chineseastrology.general.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import com.alexis.chineseastrology.IChastroActivity

inline fun <reified T : ViewModel> IChastroActivity.getViewModel(): T {
    return ViewModelProviders.of(this.fragmentActivity, this.viewModelFactory)[T::class.java] as T
}