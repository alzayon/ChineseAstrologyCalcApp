package com.alexis.chineseastrology.databinding.common

import android.databinding.BindingAdapter
import android.widget.Button
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign

object ButtonBinders {
    @BindingAdapter("android:onClick")
    @JvmStatic
    fun Button.androidOnClickBinding(callback: () -> IAnimalSign) {
        this.setOnClickListener {
            callback.invoke()
        }
    }
}