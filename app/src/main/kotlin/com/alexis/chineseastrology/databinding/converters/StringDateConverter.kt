package com.alexis.chineseastrology.databinding.converters

import android.content.Context
import java.util.*

object StringDateConverter {
    @JvmStatic
    fun dateToString(
        value: Date?,
        context: Context
    ): String {
        val format = android.text.format.DateFormat.getDateFormat(context)
        value?.let {
            return format.format(value)
        }
        return format.format(Date())
    }
}

fun Date.toDefaultFormat(context: Context) : String {
    val format = android.text.format.DateFormat.getDateFormat(context)
    this?.let {
        return format.format(this)
    }
    return format.format(Date())
}