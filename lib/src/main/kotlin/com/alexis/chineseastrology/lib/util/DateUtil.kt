package com.alexis.chineseastrology.lib.util

import java.text.SimpleDateFormat
import java.util.*
import jdk.nashorn.internal.objects.NativeDate.getTime



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

        public fun stringToDate(dateInString: String): Optional<Date> {
            val formatter = SimpleDateFormat("yyyy-MM-dd");
            try {
                val date = formatter.parse(dateInString);
                return Optional(date)
            } catch (ex: IllegalArgumentException) {
                return Optional()
            }
        }

        public fun getDateFromComponents(year: Int, month: Int, day: Int): Date {
            val cal = Calendar.getInstance()
            cal.set(year, month, day)
            return cal.time
        }
    }
}