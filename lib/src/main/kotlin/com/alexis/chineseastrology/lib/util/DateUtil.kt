package com.alexis.chineseastrology.lib.util

import java.util.*

/**
 * Created by alzayon on 3/30/2018.
 */
final class DateUtil {
    companion object {
        public fun getYearFromDate(date: Date): Int {
            val calendar = GregorianCalendar()
            calendar.time = date
            return calendar.get(Calendar.YEAR)
        }
    }
}