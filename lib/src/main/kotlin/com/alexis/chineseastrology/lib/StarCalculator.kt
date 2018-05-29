package com.alexis.chineseastrology.lib

import com.alexis.chineseastrology.lib.flyingstars.stars.IFlyingStar
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyStarBaseYear
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStar
import com.alexis.chineseastrology.lib.flyingstars.time.MonthlyFlyingStarGroup
import com.alexis.chineseastrology.lib.flyingstars.time.YearlyFlyingStarGroup

class StarCalculator : IStarCalculator {
    override fun calculateYearlyFlyingStars(year: Int): YearlyFlyingStarGroup {
        val steps = determineNumberToAdd(year)
        val flyingStarGroup = YearlyStarBaseYear.getYearlyFlyingStarsGroupForBaseYear()
                    .giveAdvancedFlyingStarGroup(steps, year)
        return flyingStarGroup as YearlyFlyingStarGroup
    }

    override fun calculateMonthlyFlyingStars(month: Int, year: Int): MonthlyFlyingStarGroup {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun calculateMonthFlyingStar(month: Int, year: Int): MonthlyFlyingStar {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun determineNumberToAdd(year: Int): Int {
        val yearlyFlyingStarGroupForBaseYear = YearlyStarBaseYear.getYearlyFlyingStarsGroupForBaseYear()
        val baseYear = yearlyFlyingStarGroupForBaseYear.year

        var remainder = 0
        if (baseYear > year) {
            remainder = baseYear % year
        } else {
            remainder = year % baseYear
        }

        return remainder
    }

    override fun getFlyingStarFromNumber(number: Int): IFlyingStar {
        if ((number > 9) || (number < 1)) {
            throw IllegalArgumentException("Invalid flying star supplied.")
        }
        val flyingStars = IFlyingStar.getAllFlyingStars()
        val found = flyingStars.findLast { it.number == number }
        return found!!
    }
}