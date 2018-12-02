package com.alexis.chineseastrology.databinding.common

import android.databinding.BindingAdapter
import android.widget.TextView
import java.util.*

object TextViewBinders {
    @BindingAdapter("android:text")
    @JvmStatic
    fun TextView.androidTextBinding(date: Date?) {
        date?.let {
            val context = this.context
            val format = android.text.format.DateFormat.getDateFormat(context);
            this.text = format.format(date)
        }
    }
}