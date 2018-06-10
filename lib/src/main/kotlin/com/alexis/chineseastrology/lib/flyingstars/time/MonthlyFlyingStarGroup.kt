package com.alexis.chineseastrology.lib.flyingstars.time

import com.alexis.chineseastrology.lib.flyingstars.stars.IFlyingStar

data class MonthlyFlyingStarGroup(val monthlyFlyingStars: Set<MonthlyFlyingStar>): BaseFlyingStarGroup() {
    var year: Int = 0
    var month: Int = 0

    init {
        doBasicStarValidation("month", monthlyFlyingStars)
        val distinctMonth = monthlyFlyingStars.distinctBy { it.year.toString() + ":" +  it.month.toString() }
        if (distinctMonth.size > 1) {
            throw IllegalArgumentException("Please supply month stars that are for the same month and year.")
        }
        year = distinctMonth.get(0).year
        month = distinctMonth.get(0).month

        setupFlyingStars(monthlyFlyingStars.toList())
    }

    fun giveAdvancedFlyingStarGroup(steps: Int):
            IFlyingStarGroup {
        if (steps == 0) {
            return MonthlyFlyingStarGroup(monthlyFlyingStars)
        }
        var monthToUse = month + steps
        var yearToUse = year
        if (monthToUse > 12) {
            monthToUse = (monthToUse % 12).toInt()
        }

        val yearsMore: Int = (month + steps) / 12
        yearToUse += yearsMore

        val monthlyFlyingStars = advanceFlyingStarsBySteps(steps, monthToUse, yearToUse)
        return MonthlyFlyingStarGroup(monthlyFlyingStars)
    }

    fun giveRewoundFlyingStarGroup(steps: Int):
            IFlyingStarGroup {
        var monthToUse = month - steps //month is within the same year
        var yearToUse = year

        //Month is in the previous years, how many?
        //Let's calculate
        if (monthToUse < 0) {
            val remainder = steps % 12
            if (remainder == 0) {
                monthToUse = month
                yearToUse = year - Math.ceil(steps.toDouble() / 12).toInt()
            } else if (monthToUse < -12) {
                val excessOfTwelve = steps % 12
                monthToUse = 12 - excessOfTwelve
                if (month != 12) {
                    monthToUse += month
                    yearToUse = year - Math.ceil(steps.toDouble() / 12).toInt()
                } else {
                    yearToUse = year - (steps / 12)
                }

            } else if (monthToUse < 0) { //The month is within the previous year only
                monthToUse = (12 - Math.abs(monthToUse))
                yearToUse--
            }
        }

        val monthlyFlyingStars = rewindFlyingStarsBySteps(steps, monthToUse, yearToUse)
        return MonthlyFlyingStarGroup(monthlyFlyingStars)
    }

    private fun advanceFlyingStarsBySteps(steps: Int, monthToUse: Int,  yearToUse: Int):
            Set<MonthlyFlyingStar> {
        val setOfStars = setOfFlyingStars()
        val newSetOfStars = setOfStars.map {
            val newFlyingStar = IFlyingStar.advanceByPosition(steps, it.giveStarPosition().flyingStar)
            val newStarPosition = it.giveStarPosition().copy(flyingStar = newFlyingStar)
            val monthlyFlyingStar = it as MonthlyFlyingStar
            return@map monthlyFlyingStar.copy(starPosition = newStarPosition,
                    month = monthToUse,
                    year = yearToUse)
        }.toSet()
        return newSetOfStars
    }

    private fun rewindFlyingStarsBySteps(steps: Int, monthToUse: Int,  yearToUse: Int):
            Set<MonthlyFlyingStar> {
        val setOfStars = setOfFlyingStars()
        val newSetOfStars = setOfStars.map {
            val newFlyingStar = IFlyingStar.rewindByPosition(steps, it.giveStarPosition().flyingStar)
            val newStarPosition = it.giveStarPosition().copy(flyingStar = newFlyingStar)
            val monthlyFlyingStar = it as MonthlyFlyingStar
            return@map monthlyFlyingStar.copy(starPosition = newStarPosition,
                    month = monthToUse,
                    year = yearToUse)
        }.toSet()
        return newSetOfStars
    }
}