package com.alexis.chineseastrology.databinding.common

import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.widget.EditText

object EditTextBinders {
    @BindingAdapter("android:text")
    @JvmStatic
    fun EditText.androidTextBinding(anInt: Int) {
        val str = anInt.toString()
        this.setText(str)
        this.setSelection(str.length)
    }

    @InverseBindingAdapter(
        attribute = "android:text",
        event = "android:textAttrChanged"
    )
    @JvmStatic
    fun EditText.androidTextBindingInverse_Int(): Int {
        val str = this.text.toString()
        if (str.isNullOrBlank()) return 0
        return Integer.parseInt(str)
    }
}