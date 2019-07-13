package com.alexis.chineseastrology.helpers

import android.databinding.InverseMethod

object StringIntConverter {
    @InverseMethod("stringToInt")
    @JvmStatic
    fun intToString(
        value: Integer?
    ): String {
        return value.toString()
    }

    @JvmStatic
    fun stringToInt(
        value: String?
    ): Integer {
        value?.let {
            if (it.trim().isEmpty()) {
                return Integer(0)
            }
            return Integer(value.toInt())
        }
        return Integer(0)
    }
}