package com.alexis.chineseastrology.lib.util

import java.util.*

/**
 * Created by alzayon on 3/30/2018.
 */
sealed class MonthlyBoundary(public val start: Pair<Int, Int>,
                             public val end: Pair<Int, Int>) {
    companion object {
        public fun convertToDate(year: Int, monthlyBoundary: MonthlyBoundary): Pair<Date, Date> {
            val month1 = monthlyBoundary.start.first
            val day1 = monthlyBoundary.start.second
            val startDate = DateUtil.getDateFromComponents(year, month1, day1)

            val month2 = monthlyBoundary.end.first
            val day2 = monthlyBoundary.end.second
            val endDate = DateUtil.getDateFromComponents(year, month2, day2)

            return Pair(startDate, endDate)
        }
    }
}

data class Month1(val s: Pair<Int, Int> = Pair(2, 4),
                  val e: Pair<Int, Int> = Pair(3, 5)) : MonthlyBoundary(s, e)

data class Month2(val s: Pair<Int, Int> = Pair(3, 6),
                  val e: Pair<Int, Int> = Pair(4, 4)) : MonthlyBoundary(s, e)

data class Month3(val s: Pair<Int, Int> = Pair(4, 5),
                  val e: Pair<Int, Int> = Pair(5, 5)) : MonthlyBoundary(s, e)

data class Month4(val s: Pair<Int, Int> = Pair(5, 6),
                  val e: Pair<Int, Int> = Pair(6, 5)) : MonthlyBoundary(s, e)

data class Month5(val s: Pair<Int, Int> = Pair(6, 6),
                  val e: Pair<Int, Int> = Pair(7, 6)) : MonthlyBoundary(s, e)

data class Month6(val s: Pair<Int, Int> = Pair(7, 7),
                  val e: Pair<Int, Int> = Pair(8, 7)) : MonthlyBoundary(s, e)

data class Month7(val s: Pair<Int, Int> = Pair(8, 8),
                  val e: Pair<Int, Int> = Pair(9, 7)) : MonthlyBoundary(s, e)

data class Month8(val s: Pair<Int, Int> = Pair(9, 8),
                  val e: Pair<Int, Int> = Pair(10, 7)) : MonthlyBoundary(s, e)

data class Month9(val s: Pair<Int, Int> = Pair(10, 8),
                  val e: Pair<Int, Int> = Pair(11, 6)) : MonthlyBoundary(s, e)

data class Month10(val s: Pair<Int, Int> = Pair(11, 7),
                  val e: Pair<Int, Int> = Pair(12, 6)) : MonthlyBoundary(s, e)

data class Month11(val s: Pair<Int, Int> = Pair(12, 7),
                  val e: Pair<Int, Int> = Pair(1, 5)) : MonthlyBoundary(s, e)

data class Month12(val s: Pair<Int, Int> = Pair(1, 6),
                  val e: Pair<Int, Int> = Pair(2, 3)) : MonthlyBoundary(s, e)
